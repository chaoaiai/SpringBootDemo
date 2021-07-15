package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.Student;
import com.example.SpringBootDemo.redis.RedisUtil;
import com.example.SpringBootDemo.repository.StudentRepository;
import com.example.SpringBootDemo.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    //OrderRepositoryImpl rs = new OrderRepositoryImpl();
    private ApplicationContext ctx;
    @Resource
    private StudentService ors;
    //连接本地的 Redis 服务
    Jedis jedis = RedisUtil.getJedis();

    @RequestMapping("/getOrder")
    public Student hello(){
        Student order = new Student("1","火锅1");
//        order.setId("1");
//        order.setTitle("火锅");
//        使用的是jackjson
        return order;
    }

    @RequestMapping("/getOrderById")
    public Student getOrderById(String id){
        //连接本地的 Redis 服务
        Jedis jedis = RedisUtil.getJedis();
        if(jedis == null){
            return ors.findById(id);
        }
        Map<String,String> mapStudent = jedis.hgetAll("getOrderById_"+id);
        Student student;
        if(mapStudent.isEmpty()){
            student = ors.findById(id);
            Map<String,String> map = new HashMap<>();
            if(student != null){
                map.put("id",student.getId());
                map.put("title",student.getTitle());
                jedis.hset("getOrderById_"+id,map);
                jedis.expire("getOrderById_"+id,60);
                System.out.println("mysql查询 有数据");
            }else{
                map.put("id","");
                map.put("title","");
                jedis.hset("getOrderById_"+id,map);
                jedis.expire("getOrderById_"+id,60);
                System.out.println("mysql查询 无数据");
                student = new Student();
            }
        }else{
            student = new Student();
            student.setId(mapStudent.get("id"));
            student.setTitle(mapStudent.get("title"));
            System.out.println("redis查询");
        }
        return student;
//        使用的是jackjson
//        return ors.findById(id);
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
