package com.jiawa.wiki.controller;

import org.springframework.web.bind.annotation.*;


@RestController
public class testController {
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

        return "hello world";
    }

    @RequestMapping("/hello/post")
    public String helloPost(String name){

        return "hello world,post,"+name;
    }
}
