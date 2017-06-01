package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 说明 @TODO
 *
 * @AUTHOR w1025
 * @DATE 2017/5/26
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://CLIENT/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
