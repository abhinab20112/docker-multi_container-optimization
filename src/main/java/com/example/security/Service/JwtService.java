package com.example.security.Service;

import com.example.security.DTO.UserDTO;

import cljs.tagged_literals.JSValue;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

import javax.crypto.SecretKey;

@Component
public class JwtService {
    JSValue("${jwt.secret}")
    private String secretKey;
    private static final long AccessEXPIRATION = 1000 * 60 * 5;
    private static final long RefreshEXPIRATION = 1000 * 60 * 15;
    public static String AccessToken(UserDTO userDTO) {
        return Jwts.builder()
                .setSubject(userDTO.getUserName()) // use subject for username
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + AccessEXPIRATION))
                .signWith(Keys.hmacShaKeyFor(SecretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public static String RefreshToken(UserDTO userDTO) {
        return Jwts.builder()
                .setSubject(userDTO.getUserName()) // also subject for refresh token
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + RefreshEXPIRATION))
                .signWith(Keys.hmacShaKeyFor(SecretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public static Claims decodeToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SecretKey.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
