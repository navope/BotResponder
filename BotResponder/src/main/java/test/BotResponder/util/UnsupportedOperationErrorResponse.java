package test.BotResponder.util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UnsupportedOperationErrorResponse {
    private String message;
    private long timestamp;
}