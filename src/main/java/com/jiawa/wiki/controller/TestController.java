package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Test;
import com.jiawa.wiki.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Value("${test.hello:Test}")
    private String testHello;

    @Resource
    private TestService testService;

    @Resource
    private RedisTemplate redisTemplate;
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

    @RequestMapping("/redis/set/{key}/{value}")
    public String set(@PathVariable Long key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value, 3600, TimeUnit.SECONDS);
        LOG.info("key: {}, value: {}", key, value);
        return "success";
    }

    @RequestMapping("/redis/get/{key}")
    public Object get(@PathVariable Long key) {
        Object object = redisTemplate.opsForValue().get(key);
        LOG.info("key: {}, value: {}", key, object);
        return object;
    }
}
