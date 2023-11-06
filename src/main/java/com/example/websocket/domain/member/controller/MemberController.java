package com.example.websocket.domain.member.controller;

import com.example.websocket.domain.member.dto.MemberRequest;
import com.example.websocket.domain.member.service.MemberService;
import com.example.websocket.global.auth.jwt.JwtTokenProvider;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberRequest.LoginDto loginDto) {
        Map<String, Object> response = memberService.login(loginDto.getUsername(),
            loginDto.getPassword());

        return ResponseEntity.ok().header(JwtTokenProvider.HEADER, (String) response.get("token"))
            .build();
    }
}
