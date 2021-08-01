package com.example.demo.entity;

import com.example.demo.models.UserModel;



public class User {
    private Integer id;
    private String name;

    public static User toModel(UserModel entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }


    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }
}
