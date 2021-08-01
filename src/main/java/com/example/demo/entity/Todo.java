package com.example.demo.entity;

import com.example.demo.models.TodoModel;


public class Todo {
    private Integer id;
    private String title;
    private String description;
    private Boolean completed;
    private Integer user;

    public static Todo toModel(TodoModel entity) {
        Todo todos = new Todo();
        todos.setCompleted(entity.getCompleted());
        todos.setId(entity.getId());
        todos.setDescription(entity.getDescription());
        todos.setTitle(entity.getTitle());
        todos.setUser(entity.getUser().getId());
        return todos;
    }

    public static String toModelString(TodoModel entity) {
        Todo todos = new Todo();
        todos.setCompleted(entity.getCompleted());
        todos.setId(1);
        todos.setDescription(entity.getDescription());
        todos.setTitle(entity.getTitle());

        return todos + "" ;
    }

    public Todo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getUser() {
        return user;
    }
    public void setUser(Integer user) {
        this.user = user;
    }
}
