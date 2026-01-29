package asciiton.potatoes.project.controller;

import asciiton.potatoes.project.dto.UserGuideResponse;
import asciiton.potatoes.project.service.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/gemini")
@RequiredArgsConstructor
public class GeminiController {

    private final GeminiService geminiService;

    @GetMapping("/guide/{userId}")
    public UserGuideResponse getUserGuide(@PathVariable Long userId) {
        return geminiService.getCustomerGuide(userId);
    }
}