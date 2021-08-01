package com.example.demo.messagingstompwebsocket;

import com.example.demo.entity.Todo;

public class Greeting {

    private Integer id;
    private String title;
    private String description;
    private Boolean completed;
    private String content;

    public Greeting() {
    }

    public Greeting(Todo content) {
        this.id = content.getId();
        this.title = content.getTitle();
        this.description = content.getDescription();
        this.completed = content.getCompleted();
    }
    public String getDescription() {
        return  description;
    }
    public String getTitle() {
        return  title;
    }
    public Boolean getCompleted() {
        return  completed;
    }
    public int getId() {
        return  id;
    }
}
