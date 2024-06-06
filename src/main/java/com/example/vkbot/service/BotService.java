package com.example.vkbot.service;

import com.example.vkbot.model.Message;
import com.example.vkbot.model.Update;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

@Service
public class BotService {

    private static final Logger logger = Logger.getLogger(BotService.class.getName());

    @Value("${vk.access-token}")
    private String accessToken;

    private final RestTemplate restTemplate = new RestTemplate();

    public String processUpdate(Update update) {
        if (update.getObject() instanceof Map) {
            Map objectMap = (Map) update.getObject();
            if (objectMap.containsKey("message")) {
                Map messageMap = (Map) objectMap.get("message");
                Message message = new Message();
                message.setPeerId((Integer) messageMap.get("peer_id"));
                message.setText((String) messageMap.get("text"));

                logger.info("Received message: " + message.getText());
                sendMessage(message.getPeerId(), message.getText());
            }
        }
        return "ok";
    }

    private void sendMessage(int peerId, String text) {
        String url = "https://api.vk.com/method/messages.send";
        String params = "user_id=" + peerId +
                "&message=" + String.format("Вы сказали: %s",text) +
                "&random_id=" + new Random().nextInt(1000000) +
                "&access_token=" + accessToken +
                "&v=5.199";

        try {
            var res = restTemplate.getForObject(url + "?" + params, String.class);
            logger.info("Message sent to user_id: " + peerId);
            logger.info(res);
        } catch (Exception e) {
            logger.severe("Failed to send message: " + e.getMessage());
        }
    }
}
