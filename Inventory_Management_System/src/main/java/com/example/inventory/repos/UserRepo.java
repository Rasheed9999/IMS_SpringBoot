package com.example.inventory.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.entity.Users;

public interface UserRepo extends JpaRepository<Users, String> {
	
	Optional<Users> findByEmail(String email);
//    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
