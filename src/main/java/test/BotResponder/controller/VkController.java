package test.BotResponder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.BotResponder.dto.CallbackDto;
import test.BotResponder.service.VkService;
import test.BotResponder.util.UnsupportedOperationErrorResponse;

@RestController
@RequestMapping(value = "/callbacks")
@RequiredArgsConstructor
public class VkController {
    private final VkService vkService;

    @PostMapping
    public ResponseEntity<String> receiveMessage(@RequestBody CallbackDto callbackDto) {
        return vkService.sendMessage(callbackDto);
    }

    @ExceptionHandler
    private ResponseEntity<UnsupportedOperationErrorResponse> handlerException(UnsupportedOperationException e) {
        UnsupportedOperationErrorResponse response = new UnsupportedOperationErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}