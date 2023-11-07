package com.example.websocket.global.websocket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatDTO {

    private Long gameId;
    private Long senderId;
    private String message;
    private String sendTime;
}
