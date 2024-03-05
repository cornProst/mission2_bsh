package com.example.mission2_bsh.controller;

import com.example.mission2_bsh.jwt.JwtRequestDto;
import com.example.mission2_bsh.jwt.JwtResponseDto;
import com.example.mission2_bsh.jwt.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("token")
@RequiredArgsConstructor
public class TokenController {
    private final JwtTokenUtils jwtTokenUtils;
    private final UserDetailsManager manager;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/issue")
    public JwtResponseDto issueJwt(@RequestBody JwtRequestDto dto) {
        log.info("");
        UserDetails userDetails = manager.loadUserByUsername(dto.getUserId());

        JwtResponseDto responseDto = new JwtResponseDto();
        responseDto.setToken(jwtTokenUtils.generateToken(userDetails));
        log.info("토근은: " + responseDto);
        return responseDto;
    }
}
