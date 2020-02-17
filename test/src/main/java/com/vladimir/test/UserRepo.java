package com.vladimir.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    List<User> findByName(String name);
    List<User> findBySurname(String surname);
    List<User> findByEmail(String email);
}
