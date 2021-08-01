package com.example.demo.service;


import com.example.demo.entity.Todo;
import com.example.demo.models.TodoModel;
import com.example.demo.models.UserModel;
import com.example.demo.repository.TodoRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepo;
    @Autowired
    private UserRepository UserRepo;

    public Todo createTodo(TodoModel todo, Integer userId) {
        UserModel user = UserRepo.findById(userId).get();

        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public String deleteTodo(Integer todoId) {
            try{
                TodoModel todo = todoRepo.findById(todoId).get();
                todoRepo.delete(todo);
                return "todo success delete !";
            } catch (Exception e) {
                return "todo not such !";
            }
//        todo.setUser(user);
//        return Todo.toModel(todoRepo.save(todo));
//        return Todo.toModel(todo);
    }

    public Todo updateTodo(Todo todoBody, Integer todoId) {
        TodoModel todo = todoRepo.findById(todoId).get();

        if (todoBody.getCompleted() != todo.getCompleted()) {
            todo.setCompleted(todoBody.getCompleted());
        }
        if (todoBody.getDescription() != null) {
            todo.setDescription(todoBody.getDescription());
        }
        if (todoBody.getTitle() != null) {
            todo.setTitle(todoBody.getTitle());
        }
        System.out.println("todoxx "+ todo.getTitle());
        return Todo.toModel(todoRepo.save(todo));
    }
}
