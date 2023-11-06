package com.example.websocket.domain.member.service;

import com.example.websocket.domain.member.entity.Member;
import com.example.websocket.domain.member.repository.MemberRepository;
import com.example.websocket.global.auth.jwt.JwtTokenProvider;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Map<String, Object> login(String username, String password) {
        Member member = memberRepository.findByUsername(username).orElseThrow();

        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new RuntimeException("패스워드가 일치하지 않습니다.");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("token", JwtTokenProvider.create(member));

        return response;
    }
}
