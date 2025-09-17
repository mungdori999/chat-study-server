//package com.example.chatserver.chat.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.*;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.util.HashSet;
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Component
//@Slf4j
//public class SimpleWebSocketHandler extends TextWebSocketHandler {
//
//    private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        sessions.add(session);
//        log.info("connected : {}", session.getId());
//    }
//
//
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String payload = message.getPayload();
//        log.info("received : {}", payload);
//        for (WebSocketSession s : sessions) {
//            if (s.isOpen()) {
//                s.sendMessage(new TextMessage(payload));
//            }
//        }
//    }
//
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        sessions.remove(session);
//        log.info("disconnected : {}", session.getId());
//    }
//
//}
