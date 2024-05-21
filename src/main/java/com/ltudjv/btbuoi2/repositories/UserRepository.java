package com.ltudjv.btbuoi2.repositories;

import com.ltudjv.btbuoi2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String userName);
}
