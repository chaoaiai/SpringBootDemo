package com.example.SpringBootDemo;

import com.example.SpringBootDemo.model.Student;
import com.example.SpringBootDemo.repository.StudentRepository;
import com.example.SpringBootDemo.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StudentController {
    //OrderRepositoryImpl rs = new OrderRepositoryImpl();
    private ApplicationContext ctx;
    @Resource
    private StudentService ors;

    @RequestMapping("/getOrder")
    public Student hello(){
        Student order = new Student("1","火锅");
//        order.setId("1");
//        order.setTitle("火锅");
//        使用的是jackjson
        return order;
    }

    @RequestMapping("/getOrderById")
    public Student getOrderById(String id){
//        使用的是jackjson
        return ors.findById(id);
    }

//    @RequestMapping("/findAll")
//    public List<Student> findAll(){
//        return ors.findAll();
//    }
//
//    @RequestMapping("/count")
//    public Long count(){
//        return ors.count();
//    }
//
//    @RequestMapping("/findAllPage")
//    public Page<Student> findAllPage(){
//        int page = 0;
//        int size = 1;
//       // Sort sort = new Sort(Sort.Direction.DESC,"id");
//        Pageable pageable = PageRequest.of(page,size);
//        Page<Student> all = ors.findALLPage(pageable);
//       // Assert. .assertEquals(1,all.getContent().size());
//      //  Assert.assertEquals(1,all.getTotalPages());
//        return all;
//    }
}
