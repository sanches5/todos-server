package com.example.demo.service;

import com.example.demo.models.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String createUser(UserModel user) {

        if (userRepository.findByName(user.getName()) != null) {
            return "a user with the same name already exists !";
        }
        if ((user.getName().length() > 20)) {
            return "name is too long no more than 20 characters";
        }

        if ((user.getPassword().length() > 8)) {
            return "password is too long no more than 8 characters";
        }
        UserModel model = new UserModel();
        model.setName(user.getName());
        model.setPassword(user.getPassword());
        userRepository.save(model);
        return "user success create !";
    }
}
