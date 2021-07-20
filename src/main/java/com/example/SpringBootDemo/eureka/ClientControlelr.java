package com.example.SpringBootDemo.eureka;

import com.example.SpringBootDemo.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClientControlelr {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/queryService")
    @ResponseBody
    public Student query() {
        List<ServiceInstance> instances =discoveryClient.getInstances("SPRINGBOOTDEMOCLIENT");
        StringBuilder urls= new StringBuilder();
        for(ServiceInstance instance : instances){
            urls.append(instance.getHost()+":"+instance.getPort()).append(",");
        }
        Student vo = new Student();
        vo.setId("SPRINGBOOTDEMOCLIENT");
        vo.setTitle(urls.toString());
        return vo;
    }
}
