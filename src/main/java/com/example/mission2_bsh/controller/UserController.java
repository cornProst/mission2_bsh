package com.example.mission2_bsh.controller;

import com.example.mission2_bsh.dto.UserDto;
import com.example.mission2_bsh.entity.UserEntity;
import com.example.mission2_bsh.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserDetailsManager manager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> signUp(
            @RequestBody
            UserDto dto
    ) {
        if (manager.userExists(dto.getUserId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("이미 존재하는 아이디");
        }
        UserEntity newUser = UserEntity.builder()
                .userId(dto.getUserId())
                .password(passwordEncoder.encode(dto.getPassword()))
                .authorities("ROLE_INERT")
                .build();
        userRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.OK).body("회원가입 완료.");
    }
}
