package com.example.mission2_bsh.repo;

import com.example.mission2_bsh.entity.UserEntity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
