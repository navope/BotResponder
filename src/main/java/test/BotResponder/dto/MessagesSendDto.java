package test.BotResponder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Builder
@Getter
@Setter
@JsonPropertyOrder(alphabetic = true)
@EqualsAndHashCode(exclude = "randomId")
public class MessagesSendDto implements Serializable {
    @JsonProperty(value = "user_id")
    Long userId;
    @JsonProperty(value = "random_id")
    Long randomId;
    String message;
}
