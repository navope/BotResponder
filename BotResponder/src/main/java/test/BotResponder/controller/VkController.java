package test.BotResponder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.BotResponder.dto.CallbackDto;
import test.BotResponder.service.VkService;

@RestController
@RequestMapping(value = "/callbacks")
@RequiredArgsConstructor
@PropertySource(value = "classpath:application.properties")
public class VkController {
    private final VkService vkService;
    @Value("${vk.api.confirmation}")
    private String callbackSecret;

    @PostMapping
    public ResponseEntity<String> receiveMessage(@RequestBody CallbackDto callbackDto) {
        return vkService.sendMessage(callbackDto);
    }
}