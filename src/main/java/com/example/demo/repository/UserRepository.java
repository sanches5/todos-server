package com.example.demo.repository;

import com.example.demo.models.UserModel;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserModel, Integer> {
    UserModel findByName (String name);

    UserModel findByNameAndPassword(String name, String password);
}
