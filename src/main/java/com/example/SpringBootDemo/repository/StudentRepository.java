package com.example.SpringBootDemo.repository;

import com.example.SpringBootDemo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Integer> {
    // 利用关键字查询
    // findXXBy、readAXXBy、queryXXBy、countXXBy、getXXBy 后面跟属性名称
    // findByUserNameOrEmail
    // findByUserNameOrderByEmailDesc
    Student findById(String id);

    //JpaRepository的接口,可以省略
    @Override
    List<Student> findAll();

    @Query(value = "select * from student",nativeQuery = true)
    Page<Student> findALLPage(Pageable pageable);
}
