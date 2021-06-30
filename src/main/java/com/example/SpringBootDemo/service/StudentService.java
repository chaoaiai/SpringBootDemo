package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.model.Student;

public interface StudentService {
    Student findById(String id);
}
