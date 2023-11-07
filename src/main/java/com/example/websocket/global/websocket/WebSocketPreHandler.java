package com.example.websocket.global.websocket;

import com.example.websocket.global.auth.jwt.JwtTokenProvider;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Component
public class WebSocketPreHandler implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);

        if (headerAccessor.getCommand() != StompCommand.CONNECT) {
            return message;
        }

        String authorizationHeader = String.valueOf(
                headerAccessor.getNativeHeader(JwtTokenProvider.HEADER)).replace("[", "")
            .replace("]", "");

        if (authorizationHeader == null) {
            throw new RuntimeException("토큰 없음");
        }

        String token = authorizationHeader.replace(JwtTokenProvider.TOKEN_PREFIX, "");

        boolean validate = JwtTokenProvider.validateToken(token);

        if (!validate) {
            throw new RuntimeException("인증 실패");
        }

        return message;
    }
}
