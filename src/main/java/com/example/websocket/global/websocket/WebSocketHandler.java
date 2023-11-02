package com.example.websocket.global.websocket;

import com.example.websocket.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {

    private final WebSocketSessionManager webSocketSessionManager;

    @Override

    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Game game = getGame(session);

        webSocketSessionManager.addSessionToRoom(game.getId(), session);
        System.out.println("[연결 성공] ID : " + game.getId() + ", SESSION : " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
        throws Exception {
        Game game = getGame(session);
        webSocketSessionManager.sendMessage(game.getId(), session, message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
        throws Exception {
        Game game = getGame(session);
        webSocketSessionManager.leaveRoom(game.getId(), session);
        System.out.println("[연결 해제] ID : " + game.getId() + ", SESSION : " + session.getId());
    }

    private Game getGame(WebSocketSession session) {
        return (Game) session.getAttributes().get("game");
    }
}
