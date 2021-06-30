package com.example.SpringBootDemo.service.impl;

import com.example.SpringBootDemo.model.Student;
import com.example.SpringBootDemo.repository.StudentRepository;
import com.example.SpringBootDemo.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentRepository ors;
    @Override
    public Student findById(String id) {
        return ors.findById(id);
    }
}
