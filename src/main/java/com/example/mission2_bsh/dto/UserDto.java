package com.example.mission2_bsh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String userId;
    private String password;
    private String nickname;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String authorities;
}
