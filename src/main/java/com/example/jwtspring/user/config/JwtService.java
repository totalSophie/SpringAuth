package com.example.jwtspring.user.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {
    private static final String SECRETKEY = "kKlV3JV8NhnjDz6iD1sRjQAsTMESp3gP";
    public String extractUsername(String token) {
        return null;
    }
    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder().setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRETKEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
