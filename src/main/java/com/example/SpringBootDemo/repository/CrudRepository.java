package com.example.SpringBootDemo.repository;


import com.example.SpringBootDemo.model.Student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface CrudRepository<T, ID> extends Repository<T, ID> {


    @Query(nativeQuery = true, value = "select * from order where id=?1")
    public Student findById2(String ID);


    public Student findById(String ID);

}
