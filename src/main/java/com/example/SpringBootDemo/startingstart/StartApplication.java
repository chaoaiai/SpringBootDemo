package com.example.SpringBootDemo.startingstart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@RestController
@SpringBootApplication //Spring Boot核心注解，用于开启自动配置
public class StartApplication implements CommandLineRunner {

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
    }
}
