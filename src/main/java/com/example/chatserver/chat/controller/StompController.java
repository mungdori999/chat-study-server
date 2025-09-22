package com.example.chatserver.chat.controller;

import com.example.chatserver.chat.dto.ChatMessageReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
@RequiredArgsConstructor
public class StompController {

    private final SimpMessageSendingOperations messageTemplate;

//    @MessageMapping("/{roomId}")
//    @SendTo("/topic/{roomId}")
//    public String sendMessage(@DestinationVariable Long roomId, String message) {
//        log.info(message);
//        return message;
//    }

    @MessageMapping("/{roomId}")
    public void sendMessage(@DestinationVariable Long roomId, ChatMessageReqDto chatMessageReqDto) {
        log.info(chatMessageReqDto.getMessage());
        messageTemplate.convertAndSend("/topic/" + roomId, chatMessageReqDto);

    }
}
