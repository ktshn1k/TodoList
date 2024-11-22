// Import necessary packages
package com.example.springtodolist.entity.data.service;

import com.example.springtodolist.entity.TodoElement;
import com.example.springtodolist.entity.data.repo.TodoElementRepo;

import org.springframework.stereotype.Service;

import java.util.List;

// Annotate the class as a Service to indicate that it's a Spring service class
@Service
public class TodoElementService {

    // Declare a TodoElementRepo instance for interacting with the database
    private TodoElementRepo todoElementRepo;

    // Constructor-based dependency injection for TodoElementRepo
    public TodoElementService(TodoElementRepo todoElementRepo) {
        this.todoElementRepo = todoElementRepo;
    }

    // Method to create a new TodoElement item
    public void createItem(String text, boolean markTaskAsComplete, String addDate) {
        TodoElement element = new TodoElement(text, markTaskAsComplete, addDate);
        todoElementRepo.save(element);
    }

    // Method to find a TodoElement item by its ID
    public TodoElement findItem(Long id) {
        return todoElementRepo.findTodoElementById(id);
    }

    // Method to find all TodoElement items
    public List<TodoElement> findAll() {
        return todoElementRepo.findAll();
    }

    // Method to edit a TodoElement item
    public void editItem(Long id, String text) {
        TodoElement element = todoElementRepo.findTodoElementById(id);
        element.setText(text);
        todoElementRepo.save(element);
    }

    // Method to delete a TodoElement item by its ID
    public void deleteItem(Long id) {
        todoElementRepo.deleteById(id);
    }

    // Method to set the completion status of a TodoElement item
    public void setIsComplete(Long id, boolean markTaskAsComplete) {
        TodoElement element = findItem(id);
        element.setMarkTaskAsComplete(markTaskAsComplete);
        todoElementRepo.save(element);
    }

    // Method to delete all completed TodoElement items
    public void deleteAllCompletedTasks(){
        List<TodoElement> completedTask = findAllCompletedTasks();
        for(TodoElement task : completedTask){
            todoElementRepo.deleteById(task.getId());
        }
    }

    // Method to find all completed TodoElement items
    public List<TodoElement> findAllCompletedTasks() {
        return todoElementRepo.findAllByMarkTaskAsComplete(true);
    }

    // Method to find all not completed TodoElement items
    public List<TodoElement> findAllNotCompletedTasks() {
        return todoElementRepo.findAllByMarkTaskAsComplete(false);
    }
}