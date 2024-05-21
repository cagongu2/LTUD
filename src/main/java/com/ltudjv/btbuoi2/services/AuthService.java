package com.ltudjv.btbuoi2.services;

import com.ltudjv.btbuoi2.entities.User;

public interface AuthService {
    Boolean Login(String userName, String password);
    Boolean Register(User user);
}
