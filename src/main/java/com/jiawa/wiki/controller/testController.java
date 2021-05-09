package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Test;
import com.jiawa.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class testController {


    @Value("${test.hello:Test}")
    private String testHello;

    @Resource
    private TestService testService;
    /**
     * get，post，put，delete
     * /user/id=1
     * /user/1   resful风格写法
     * @return
     */
    //这个接口支持所有的请求方式
    //    @GetMapping("hello")
    //    @PostMapping("/hello")
    //    @PutMapping("/hello")
    //    @DeleteMapping("/hello")
    //    @RequestMapping(value = "/hello",method = RequestMethod.GET)  等同于@GetMapping("hello")
    //    @RequestMapping(value = "/hello",method = RequestMethod.DELETE)   等同于@DeleteMapping("/hello")
    @RequestMapping("/hello")
    public String hello(){

        return "hello world,"+testHello;
    }

    @RequestMapping("/hello/post")
    public String helloPost(String name){

        return "hello world,post,"+name;
    }

    @GetMapping("/test/list")
    public List<Test> list(){

        return testService.list();
    }
}
