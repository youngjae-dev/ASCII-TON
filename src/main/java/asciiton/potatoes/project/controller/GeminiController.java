package asciiton.potatoes.project.controller;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Gemini AI", description = "제미나이 AI 연동 테스트 API")
@RestController
public class GeminiController {

    @Value("${google.genai.api-key}")
    private String apiKey;

    @Value("${google.genai.model}")
    private String model;

    @Operation(summary = "AI에게 질문하기", description = "프롬프트를 입력하면 Gemini가 답변을 반환합니다.")
    @GetMapping("/api/v1/gemini/ask")
    public String askGemini(@RequestParam(value = "prompt", defaultValue = "안녕! 자기소개 부탁해") String prompt) {
        try {
            // 1. 클라이언트 생성 (yml에서 읽어온 apiKey 사용)
            Client client = Client.builder()
                    .apiKey(apiKey)
                    .build();

            // 2. Gemini에게 메시지 전송
            GenerateContentResponse response = client.models.generateContent(model, prompt, null);

            // 3. 응답 텍스트 반환
            return response.text();
        } catch (Exception e) {
            // 에러 발생 시 메시지 출력 (API 키가 잘못되었거나 네트워크 문제 등)
            return "AI 호출 중 에러가 발생했습니다: " + e.getMessage();
        }
    }
}