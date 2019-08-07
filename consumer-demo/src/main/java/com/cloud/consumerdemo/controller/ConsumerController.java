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
            //设置在一个滚动窗口中，打开断路器的最少请求数。请求10次才会打开
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            //设置在回路被打开，拒绝请求到再次尝试请求并决定回路是否继续打开的时间。 （失败后重试，重试成功后关闭）
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //设置打开回路并启动回退逻辑的错误比率。
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
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
