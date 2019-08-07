package com.cloud.consumerdemo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by yangxiong on 2019/8/6.
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "testTemplateFail")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/testTemplate")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "30000")
    })
    public String testTemplate(){
        String account = restTemplate.getForObject("http://user-server/account/1", String.class);
        log.debug("account :  " + account.toString());
        return account;
    }

    public String testTemplateFail(){
        return "访问出错";
    }
}
