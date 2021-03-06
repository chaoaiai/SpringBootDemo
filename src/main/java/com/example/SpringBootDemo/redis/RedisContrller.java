package com.example.SpringBootDemo.redis;

import com.example.SpringBootDemo.model.Student;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.*;


public class RedisContrller {
    public static void main(String[] args) {

        //连接本地的 Redis 服务
        Jedis jedis = RedisUtil.getJedis();

        // string
        //设置 redis 字符串数据
        jedis.set("abc", "www.runoob.com");
        jedis.expire("abc",60);
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("abc"));

        //list
        // 存储数据到列表中
        jedis.lpush("top_list","1.中国");
        jedis.lpush("top_list","2.美国");
        jedis.lpush("top_list","3.俄罗斯");
        jedis.expire("top_list",60);
        System.out.println(jedis.llen("top_list"));
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("top_list",0,jedis.llen("top_list"));
        for (String a:list) {
            System.out.println("redis 列表项为: "+ a);
        }

        //key
        //获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }

        // hash
        Student student = new Student();
        Map<String,String> map = new HashMap<>();
        map.put("name","aaaaa");
        map.put("age","18");
        jedis.hset("hstudent",map);
        jedis.expire("hstudent",60);



    }

}
