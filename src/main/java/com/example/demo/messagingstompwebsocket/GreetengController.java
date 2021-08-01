package com.example.demo.messagingstompwebsocket;

import com.example.demo.entity.Todo;
import com.example.demo.models.TodoModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetengController {
    @MessageMapping("tasks/create")
    @SendTo("/listener/user")
    public Greeting greeting(TodoModel message) throws Exception {
        Thread.sleep(1000);
        Todo todos = new Todo();
        todos.setCompleted(false);
        todos.setId(1);
        todos.setDescription(message.getDescription());
        todos.setTitle(message.getTitle());
        return new Greeting(todos);
    }
}
