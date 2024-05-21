package com.ltudjv.btbuoi2.services;

import com.ltudjv.btbuoi2.entities.User;
import com.ltudjv.btbuoi2.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Override
    public Boolean Login(String userName, String password) {
        User foundUser = userRepository.findByUsername(userName);

        if (foundUser == null) {
            return false;
        } else return foundUser.getPassword().equals(password);
    }

    @Override
    public Boolean Register(User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());

        if (foundUser != null) {
            return false;
        }

        userService.addUser(user);

        return true;
    }
}
