package com.example.websocket.global.auth.jwt;

import com.example.websocket.domain.member.entity.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public static final Long EXP = 1000L * 60 * 60 * 24;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER = "Authorization";

    public static String SECRET;

    @Value("${my-env.jwt.key}")
    public void setSECRET(String secret) {
        SECRET = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public static Long getMemberIdFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJwt(token).getBody()
            .get("id", Long.class);
    }

    public static boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String create(Member member) {
        Claims claims = Jwts.claims();
        claims.put("id", member.getId());
        claims.put("username", member.getUsername());

        String jwt = Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + EXP))
            .signWith(SignatureAlgorithm.HS256, SECRET)
            .compact();

        return TOKEN_PREFIX + jwt;
    }
}
