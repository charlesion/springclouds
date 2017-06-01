package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * 说明 @TODO
 *
 * @AUTHOR w1025
 * @DATE 2017/5/26
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
