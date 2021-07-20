package com.example.SpringBootDemo.feign;

import com.example.SpringBootDemo.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "SPRINGBOOTDEMOCLIENT")
public interface OrderFeignClient {
    @PostMapping("/getOrderById?id={orderId}")
    Student getOrder(@PathVariable("orderId")String orderId);
}
