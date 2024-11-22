// Import necessary packages
package com.example.springtodolist.entity;

import jakarta.persistence.*;

// Annotate the class as an Entity to indicate that it's a JPA entity
@Entity
public class TodoElement {

    // Annotate the field as the primary key and specify the generation strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Annotate the field as a Column and specify its length
    @Column(length = 1000)
    private String text;
    private boolean markTaskAsComplete;
    private String addDate;

    // Constructor with all fields
    public TodoElement(String text, boolean markTaskAsComplete, String addDate) {
        this.text = text;
        this.markTaskAsComplete = markTaskAsComplete;
        this.addDate = addDate;
    }

    // Constructor with only text and addDate fields
    public TodoElement(String text, String addDate) {
        this.text = text;
        this.addDate = addDate;
    }

    // Default constructor
    public TodoElement() {

    }

    // Getter for id
    public Long getId(){
        return id;
    }

    // Getter and setter for text
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // Getter and setter for markTaskAsComplete
    public boolean markTaskAsComplete() {
        return markTaskAsComplete;
    }

    public void setMarkTaskAsComplete(boolean markTaskAsComplete) {
        this.markTaskAsComplete = markTaskAsComplete;
    }

    // Getter and setter for addDate
    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }
}
