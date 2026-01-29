package asciiton.potatoes.project.service;

import asciiton.potatoes.project.domain.User;
import asciiton.potatoes.project.dto.UserGuideResponse;
import asciiton.potatoes.project.repository.UserRepository;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeminiService {

    private final UserRepository userRepository;

    @Value("${google.genai.api-key}")
    private String apiKey;

    @Value("${google.genai.model}")
    private String model;

    // GeminiService.java 의 getCustomGuide 메서드 수정
    public UserGuideResponse getCustomerGuide(Long userId) {
        // 1. DB 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        // 2. AI 호출
        String prompt = String.format(
                "너는 사회복지사야. 아래 사용자의 특성을 고려해서 아주 친절한 '첫 안내 멘트'를 작성해줘.\n" +
                        "1. 이름: %s\n" +
                        "2. 유형: %s\n\n" +
                        "--- 규칙 ---\n" +
                        "- 발달 장애인: 문장은 짧게 하되, '반가워요', '함께해요' 같은 다정한 표현을 넣어줘. (최대 3문장)\n" +
                        "- 시각 장애인: 소리나 촉각을 언급하며 안내해줘. (예: 저의 목소리가 들리시나요?)\n" +
                        "- 공통: 딱딱한 지시가 아니라 따뜻한 대화체로 써줘.",
                user.getName(),
                user.getType().getDescription()
        );

        String aiResult;
        try {
            Client client = Client.builder().apiKey(apiKey).build();
            GenerateContentResponse response = client.models.generateContent(model, prompt, null);
            aiResult = response.text();
        } catch (Exception e) {
            aiResult = "안내를 생성할 수 없습니다.";
        }

        // 3. DTO로 변환하여 리턴
        return UserGuideResponse.builder()
                .name(user.getName())
                .type(user.getType().name())
                .typeKorean(user.getType().getDescription())
                .guideText(aiResult)
                .build();
    }
}
