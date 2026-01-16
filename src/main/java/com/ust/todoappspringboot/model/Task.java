package com.ust.todoappspringboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


//id: int
//name: String
//description: String
//dueDate: LocalDate
//status: enum (PENDING, COMPLETED)
@Data
@Entity
public class Task {
    @Id
    private int id;
    private String name;
    private String description;
    private LocalDate dueDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    public enum Status{
        PENDING,
        COMPLETED
    }
private boolean deleted=Boolean.FALSE;
}
