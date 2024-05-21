package com.ltudjv.btbuoi2.services;

import com.ltudjv.btbuoi2.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> listUsers();
    User addUser(User user);
    User updateUser(UUID userId, User user);
    User deleteUser(UUID userId);
}
