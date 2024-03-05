package com.example.mission2_bsh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@Table(name = "user_table")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String password;

    private String nickName;
    private String userName;
    private String age;

    private String email;
    private String phone;
    @Setter
    private String authorities;
}
