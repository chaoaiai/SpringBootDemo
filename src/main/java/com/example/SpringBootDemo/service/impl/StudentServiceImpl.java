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
//        try
//        {
//            System.out.println("dao阻塞");
//            Thread.sleep(10000);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return ors.findById(id);
    }
}
