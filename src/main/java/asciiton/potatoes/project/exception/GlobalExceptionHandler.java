package asciiton.potatoes.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice // 모든 컨트롤러에서 발생하는 에러를 여기서 잡습니다.
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND) // 500 대신 404(찾을 수 없음)를 보냅니다.
                .body(Map.of("message", e.getMessage()));
    }
}
