package test.BotResponder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import test.BotResponder.config.VkApiConfigurationProperties;
import test.BotResponder.dto.CallbackDto;
import test.BotResponder.dto.MessagesSendDto;

import java.net.URI;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class VkService {
    private final VkApiConfigurationProperties vkApiConfigurationProperties;
    private final VkUriCreator vkUriCreator;
    private final RestTemplate restTemplate;
    private static final Random random = new Random();
    public ResponseEntity<String> sendMessage(CallbackDto callbackDto) {
        switch (callbackDto.getType()) {
            case confirmation:
                return ResponseEntity.ok(vkApiConfigurationProperties.getConfirmation());
            case message_new:
                MessagesSendDto message = parseMessageNewCallback(callbackDto);
                URI uri = vkUriCreator.createUri(message);
                ResponseEntity<CallbackDto> responseEntity = restTemplate.postForEntity(
                        uri, null, CallbackDto.class);
                return ResponseEntity.ok("ok");
            default: {
                throw new UnsupportedOperationException("Service support only 'message_new' and 'confirmation' callback type");
            }
        }
    }
    private static MessagesSendDto parseMessageNewCallback(CallbackDto callbackDto) {
        return MessagesSendDto.builder()
                .userId(callbackDto.getObject().getMessage().getFromId())
                .randomId(random.nextLong())
                .message("Вы сказали: ".concat(callbackDto.getObject().getMessage().getText()))
                .build();
    }
}
