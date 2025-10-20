package com.example.security.POJO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtPOJO {
    private String AccessToken;
    private String RefreshToken;
}
