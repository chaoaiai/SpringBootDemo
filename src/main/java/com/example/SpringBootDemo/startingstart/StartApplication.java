package com.example.SpringBootDemo.startingstart;

import com.example.SpringBootDemo.model.Student;
import com.example.SpringBootDemo.redis.RedisUtil;
import com.example.SpringBootDemo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication //Spring Boot核心注解，用于开启自动配置
public class StartApplication implements CommandLineRunner {
    @Resource
    private StudentRepository ors;
    //程序可以直接在此启动
    @RequestMapping("/")
    String index(){
        System.out.println("index");
        return "ok";
    }

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //配置静态资源处理
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/META-INF/")
//                .addResourceLocations("classpath:/hospitalpay");
//    }

    @Override
    public void run(String... args) throws Exception {
        //项目启动时会执行这里的任务
        //通常加载用于系统参数加载
        System.out.println("run");
        List<Student> list = ors.findAll();
        //连接本地的 Redis 服务
        Jedis jedis = RedisUtil.getJedis();
        Map<String,String> map = new HashMap<>();
        for(Student a:list){
            map.put("id",a.getId());
            map.put("title",a.getTitle());
            jedis.hset("getOrderById_"+a.getId(),map);
            jedis.expire("getOrderById_"+a.getId(),60);
        }
        System.out.println("redis添加缓存数据");
    }
}
