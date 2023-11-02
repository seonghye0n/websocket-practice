package com.example.websocket.global.websocket;

import com.example.websocket.domain.Game;
import com.example.websocket.repository.GameRepository;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Component
@RequiredArgsConstructor
public class CustomHandShakeInterceptor extends HttpSessionHandshakeInterceptor {

    private final GameRepository gameRepository;

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
        WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        attributes.put("game", getGame(request));

        return true;
    }

    private Game getGame(ServerHttpRequest request) {
        Long gameId = parseGameId(request);
        Game game = gameRepository.findById(gameId).orElseThrow();

        return game;
    }

    private static Long parseGameId(ServerHttpRequest request) {
        String path = request.getURI().getPath();
        String gameId = path.substring(path.lastIndexOf('/') + 1);
        return Long.parseLong(gameId);
    }
}
