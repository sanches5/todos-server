package com.example.demo.controllers;



import com.example.demo.entity.Todo;
import com.example.demo.models.TodoModel;
import com.example.demo.repository.TodoRepository;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public ResponseEntity rest(@RequestParam Integer userId) {
        try {
            TodoModel todos = todoRepository.findByUserId(userId);
            return ResponseEntity.ok(Todo.toModel(todos));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/create")
    public ResponseEntity createTodo(
            @RequestBody TodoModel todo,
            @RequestParam Integer userId) {

        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteTodo(@RequestParam Integer todoId) {
        try {
            return ResponseEntity.ok(todoService.deleteTodo(todoId));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity updateTodo(@RequestBody Todo todo, @RequestParam Integer todoId) {
        try {
            return ResponseEntity.ok(todoService.updateTodo(todo, todoId));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
