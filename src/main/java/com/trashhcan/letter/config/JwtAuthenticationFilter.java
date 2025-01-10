//package com.trashhcan.letter.config;
//
//import com.trashhcan.letter.config.jwt.JwtTokenProvider;
//import com.trashhcan.letter.config.jwt.JwtValidationType;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    private final JwtTokenProvider jwtTokenProvider;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//        try {
//            final String token = getJwtFromRequest(request);
//            JwtValidationType jwtValidationType = jwtTokenProvider.validateToken(token);
//            if(jwtValidationType == JwtValidationType.VALID_JWT){
//                Long memberId = jwtTokenProvider.getMemberIdFromAccessToken(token);
//                MemberAuthentication authentication = MemberAuthentication.createMemberAuthentication(memberId);
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            } else {
//                log.error("Jwt status :" + jwtValidationType.toString());
//            }
//        } catch (Exception e){
//            log.error(e.getMessage());
//        }
//        filterChain.doFilter(request, response);
//    }
//
//    private String getJwtFromRequest(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
//            return bearerToken.substring("Bearer ".length());
//        }
//        return null;
//    }
//}
