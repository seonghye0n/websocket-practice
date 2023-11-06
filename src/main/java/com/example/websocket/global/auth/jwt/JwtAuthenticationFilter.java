package com.example.websocket.global.auth.jwt;

import com.example.websocket.domain.member.entity.Member;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    private JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);

        if (jwtTokenProvider == null) {
            this.jwtTokenProvider = new JwtTokenProvider();
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain chain) throws IOException, ServletException {
        String jwt = request.getHeader(JwtTokenProvider.HEADER);

        if (jwt == null) {
            chain.doFilter(request, response);
            return;
        }

        jwt = jwt.replace(JwtTokenProvider.TOKEN_PREFIX, "");

        if (!JwtTokenProvider.validateToken(jwt)) {
            chain.doFilter(request, response);
        }

        Member member = Member.builder()
            .id(JwtTokenProvider.getMemberIdFromToken(jwt))
            .build();

        MemberDetails memberDetails = new MemberDetails(member);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
            memberDetails, memberDetails.getPassword(), memberDetails.getAuthorities());

        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        chain.doFilter(request, response);
    }
}
