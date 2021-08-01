package com.example.demo.controllers;


import com.example.demo.entity.User;
import com.example.demo.models.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity getUser(
            @RequestParam String name,
            @RequestParam String password) {

        try {
            UserModel user = userRepository.findByNameAndPassword(name, password);
            return ResponseEntity.ok(User.toModel(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody UserModel user) {
        try {
            UserModel userEntity = userRepository.findByName(user.getName());
            if(userEntity != null) {
                return ResponseEntity.badRequest().body("a user with the same name already exists");
            }
            return ResponseEntity.ok(userService.createUser(user));

        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
