package com.usmanghani.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usmanghani.userservice.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String username);

}
