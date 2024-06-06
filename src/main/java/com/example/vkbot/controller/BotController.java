package com.example.vkbot.controller;

import com.example.vkbot.model.Update;
import com.example.vkbot.service.BotService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class BotController {

    private static final Logger logger = Logger.getLogger(BotController.class.getName());

    private final BotService botService;

    @Value("${vk.confirmation-token}")
    private String confirmationToken;

    public BotController(BotService botService) {
        this.botService = botService;
    }

    @PostMapping("/callback")
    public String callback(@RequestBody Update update) {
        logger.info("Received update of type: " + update.getType());
        if ("confirmation".equals(update.getType())) {
            return confirmationToken;
        } else if ("message_new".equals(update.getType())) {
            return botService.processUpdate(update);
        }
        return "ok";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        e.printStackTrace();
        logger.severe("Error occurred: " + e.getMessage());
        return "error";
    }
}
