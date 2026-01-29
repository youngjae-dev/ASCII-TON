package asciiton.potatoes.project.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserType {
    SENIOR("노인"),
    FOREIGNER("외국인"),
    DEVELOPMENTAL("발달 장애인"),
    HEARING("청각 장애인"),
    VISUAL("시각 장애인"),
    NORMAL("일반인");

    private final String description;
}
