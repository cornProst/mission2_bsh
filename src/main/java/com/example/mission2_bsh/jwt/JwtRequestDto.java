package com.example.mission2_bsh.jwt;

import lombok.Data;

@Data
public class JwtRequestDto {
    private String userId;
    private String password;
}
