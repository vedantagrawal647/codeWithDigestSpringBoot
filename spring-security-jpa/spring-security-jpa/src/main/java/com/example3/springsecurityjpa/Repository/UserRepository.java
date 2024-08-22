package com.example3.springsecurityjpa.Repository;

import com.example3.springsecurityjpa.model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserTable,Integer> {
    Optional<UserTable> findByUserName(String userName);
}
