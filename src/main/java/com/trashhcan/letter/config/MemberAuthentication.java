//package com.trashhcan.letter.config;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.Collection;
//
//public class MemberAuthentication extends UsernamePasswordAuthenticationToken {
//    public MemberAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
//        super(principal, credentials, authorities);
//    }
//
//    public static MemberAuthentication createMemberAuthentication(Long id) {
//        return new MemberAuthentication(id, null, null);
//    }
//}
