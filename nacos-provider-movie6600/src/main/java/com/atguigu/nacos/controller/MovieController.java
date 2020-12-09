package com.atguigu.nacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.nacos.bean.Movie;
import com.atguigu.nacos.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * wbq
 * 2020/12/7
 */
@RefreshScope
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @Value("${server.port}")
    private String port;

    @Value("${myName}")
    private String name;

    @Value("${username}")
    private String username;

    @Value("${redis.password}")
    private String password;


    // 获取最新电影
    @GetMapping("/latest")
    public Movie getNewMovie(){
        System.out.println("port=" + port);
        return movieService.getNewMovie();
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello " +name + ",username:"+username+",password:"+password;
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2)
    {
        //int age = 10/0;
        return "------testHotKey";
    }
    //兜底方法
    public String deal_testHotKey (String p1, String p2, BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o";
    }

}
