package com.mejner.myworklistservice.service;

import com.mejner.myworklistservice.domain.Todo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@EqualsAndHashCode
public class TodoServiceImpl implements TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "Marczu", "Nauczyć sie pływać", new Date(),false ));
        todos.add(new Todo(++idCounter, "Marczu", "Nauczyć microserviców", new Date(),false ));
        todos.add(new Todo(++idCounter, "Marczu", "Nauczyć się grać na gitarze", new Date(),false ));
    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo saveTodo(Todo todo){
        if(todo.getId() == -1 || todo.getId() == 0){
            todo.setId(++idCounter);
            todos.add(todo);
        }else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public Todo deleteById(long id){
        Todo todo = findById(id);

        if(todo == null) return null;

        todos.remove(todo);

        return todo;
    }

    public Todo findById(long id) {
        for(Todo todo: todos){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }


}
