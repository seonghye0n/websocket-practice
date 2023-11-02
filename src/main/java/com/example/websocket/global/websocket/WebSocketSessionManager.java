package com.example.websocket.global.websocket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
@RequiredArgsConstructor
public class WebSocketSessionManager {

    private final Map<Long, Set<WebSocketSession>> chatRoomSessions;

    public void addRoom(Long roomId) {
        if (chatRoomSessions.containsKey(roomId)) {
            return;
        }

        Set<WebSocketSession> sessions = new HashSet<>();

        chatRoomSessions.put(roomId, sessions);
    }

    public void addSessionToRoom(Long roomId, WebSocketSession session) {
        addRoom(roomId);

        Set<WebSocketSession> sessions = getSessions(roomId);

        sessions.add(session);
    }

    public Set<WebSocketSession> getSessions(Long roomId) {
        return chatRoomSessions.get(roomId);
    }

    public void sendMessage(Long roomId, WebSocketSession session, TextMessage message)
        throws IOException {
        Set<WebSocketSession> sessions = getSessions(roomId);

        for (WebSocketSession sendSession : sessions) {
            if (sendSession.equals(session)) {
                continue;
            }
            
            sendSession.sendMessage(message);
        }
    }

    public void leaveRoom(Long roomId, WebSocketSession session) {
        chatRoomSessions.remove(roomId, session);
    }
}
