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

@RestController
@RequestMapping(value = "/callbacks")
@RequiredArgsConstructor
@PropertySource(value = "classpath:application.properties")
public class CallbackController {
    @Value("${vk.api.confirmation}")
    private String callbackSecret;

    @PostMapping
    public ResponseEntity<String> handleCallback(@RequestBody CallbackDto callbackDto) {
        return new ResponseEntity<>(callbackSecret, HttpStatus.OK);
    }
}