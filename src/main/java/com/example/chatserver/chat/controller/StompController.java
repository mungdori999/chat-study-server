package com.example.chatserver.chat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class StompController {

    @MessageMapping("/{roomId}")
    @SendTo("/topic/{roomId}")
    public String sendMessage(@DestinationVariable Long roomId, String message) {
        log.info(message);
        return message;
    }
}
