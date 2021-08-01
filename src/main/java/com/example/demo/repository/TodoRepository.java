package com.example.demo.repository;

import com.example.demo.models.TodoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<TodoModel, Integer> {
    TodoModel findByUserId(Integer user_id);
}
