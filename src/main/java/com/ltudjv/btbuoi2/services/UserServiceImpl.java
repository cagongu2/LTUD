package com.ltudjv.btbuoi2.services;

import com.ltudjv.btbuoi2.entities.User;
import com.ltudjv.btbuoi2.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        User saveUser = User.builder()
                .id(UUID.randomUUID())
                .username(user.getUsername())
                .password(user.getPassword())
                .gmail(user.getGmail())
                .profession(user.getProfession())
                .birthday(user.getBirthday())
        .build();

        return userRepository.save(saveUser);
    }

    @Override
    public User updateUser(UUID userId, User user) {

        User foundUser = userRepository.findById(userId).orElse(null);

        if ((foundUser != null)){
            foundUser.setUsername(user.getUsername());
            foundUser.setPassword(user.getPassword());
            foundUser.setGmail(user.getGmail());
            foundUser.setBirthday(user.getBirthday());
            foundUser.setProfession(user.getProfession());
            userRepository.save(foundUser);
        }

        return foundUser;
    }

    @Override
    public User deleteUser(UUID userId) {

        User foundUser = userRepository.findById(userId).orElse(null);

        if (foundUser != null){
            userRepository.delete(foundUser);
        }

        return foundUser;
    }
}
