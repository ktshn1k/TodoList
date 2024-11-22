// Import necessary packages
package com.example.springtodolist.controller;

import com.example.springtodolist.entity.TodoElement;
import com.example.springtodolist.entity.data.service.TodoElementService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// Annotate the class as a Controller class to indicate that it should handle HTTP requests
@Controller
public class MainContoller {

    // Declare a TodoElementService instance
    private TodoElementService todoElementService;

    // Constructor-based dependency injection for TodoElementService
    public MainContoller(TodoElementService todoElementService){
        this.todoElementService = todoElementService;
    }

    // Handle GET requests for the root URL
    @GetMapping("")
    public String index(Model model){
        // Fetch not completed and completed tasks
        List<TodoElement> notCompletedTask = todoElementService.findAllNotCompletedTasks();
        List<TodoElement> completedTask = todoElementService.findAllCompletedTasks();

        // Add attributes to the model
        model.addAttribute("elementsCompleted", completedTask);
        model.addAttribute("elementsNotCompleted", notCompletedTask);

        // Return the index view
        return "index";
    }

    // Handle POST requests for creating a new element
    @PostMapping("/createElement")
    public String createElement(@RequestParam String task) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if (!task.isEmpty()) {
                todoElementService.createItem(task, false, dateFormat.format(new Date()));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

    // Handle POST requests for deleting an element
    @PostMapping("/deleteElement")
    public String deleteElement(@RequestParam("taskId") long id){
        todoElementService.deleteItem(id);
        return "redirect:/";
    }

    // Handle POST requests for editing an element
    @PostMapping("/editElement")
    public String editElement(@RequestParam("taskId") long id, @RequestParam("taskText") String taskText){
        try{
            todoElementService.editItem(id, taskText);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

    // Handle POST requests for deleting all completed tasks
    @PostMapping("/deleteAllCompletedTasks")
    public String deleteAllCompletedTasks(){
        todoElementService.deleteAllCompletedTasks();
        return "redirect:/";
    }

    // Handle POST requests for toggling task completion status
    @PostMapping("/taskСomplete/{id}")
    public String toggleTaskCompletion(@PathVariable("id") long id, boolean taskIsComplete){
        todoElementService.setIsComplete(id, !taskIsComplete);
        return "redirect:/";
    }
}