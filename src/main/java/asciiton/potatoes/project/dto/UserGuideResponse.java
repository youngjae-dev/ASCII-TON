package asciiton.potatoes.project.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGuideResponse {
    private String name;        // 사용자 이름
    private String type;        // 사용자 유형 (예: VISUAL, SENIOR)
    private String typeKorean;  // 사용자 유형 한글 설명 (예: 시각 장애인)
    private String guideText;   // Gemini가 생성한 맞춤형 가이드 문구
}