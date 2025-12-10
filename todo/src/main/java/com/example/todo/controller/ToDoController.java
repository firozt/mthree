package com.example.todo.controller;

import com.example.todo.dao.ToDoDao;
import com.example.todo.model.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin
public class ToDoController {

    private final ToDoDao dao;


    public ToDoController(ToDoDao dao) {
        this.dao = dao;
    }

    @GetMapping("/todos")
    public List<ToDo> getAll(){
        return dao.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> findById(@PathVariable int id){
        ToDo result  = dao.findById(id);
        if(result == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ToDo create(@RequestBody ToDo todo) {
        return dao.add(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(dao.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody ToDo todo){
        String msg = "";
        ResponseEntity response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        if(id != todo.getId()) {
            msg = "IDs do not match";
            response = ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(msg);
        } else if(dao.update(todo)){
            msg = "Todo was updated";
            response = ResponseEntity.status(HttpStatus.OK).body(msg);
        }
        return response;
    }
}
