package test.BotResponder.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallbackDto {
    private CallbackType type;
    private ObjectDto object;
    @JsonProperty(value = "group_id")
    private Long groupId;
    private String secret;
    @JsonProperty(value = "event_id")
    private String eventId;

    public enum CallbackType {
        message_new, confirmation, UNKNOWN;

        @JsonCreator
        public static CallbackType fromString(String key) {
            for (CallbackType type : CallbackType.values()) {
                if (type.name().equalsIgnoreCase(key)) {
                    return type;
                }
            }
            return UNKNOWN;
        }

        @JsonValue
        public String toValue() {
            return this.name().toLowerCase();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectDto {
        private MessageDto message;
        @JsonProperty(value = "client_info")
        private ClientInfoDto clientInfo;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MessageDto {
        private Long date;
        @JsonProperty(value = "from_id")
        private Long fromId;
        private Long id;
        private Integer out;
        private Integer version;
        private List<Object> attachments;
        @JsonProperty(value = "conversation_message_id")
        private Long conversationMessageId;
        @JsonProperty(value = "fwd_messages")
        private List<Object> fwdMessages;
        private Boolean important;
        @JsonProperty(value = "is_hidden")
        private Boolean isHidden;
        @JsonProperty(value = "peer_id")
        private Long peerId;
        @JsonProperty(value = "random_id")
        private Integer randomId;
        private String text;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ClientInfoDto {
        @JsonProperty(value = "button_actions")
        private List<String> buttonActions;
        private Boolean keyboard;
        @JsonProperty(value = "inline_keyboard")
        private Boolean inlineKeyboard;
        private Boolean carousel;
        @JsonProperty(value = "lang_id")
        private Integer langId;
    }
}
