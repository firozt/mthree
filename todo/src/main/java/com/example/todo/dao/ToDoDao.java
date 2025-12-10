package com.example.todo.dao;

import com.example.todo.model.ToDo;
import java.util.List;

public interface ToDoDao {
    ToDo add(ToDo todo);
    List<ToDo> getAll();
    ToDo findById(int id);
    boolean update(ToDo todo);
    boolean delete(int id);
}
