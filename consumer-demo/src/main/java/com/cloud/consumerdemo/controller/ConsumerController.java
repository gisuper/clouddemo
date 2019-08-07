package com.cloud.consumerdemo.controller;

import com.cloud.consumerdemo.feignclient.ConsumerFeignClient;
import com.cloud.consumerdemo.pojo.Account;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private ConsumerFeignClient feignClient;


    @GetMapping("/testTemplate")
/*    @HystrixCommand(commandProperties = {
            //设置在一个滚动窗口中，打开断路器的最少请求数。请求10次才会打开 默认20
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            //设置在回路被打开，拒绝请求到再次尝试请求并决定回路是否继续打开的时间。 （失败后重试，重试成功后关闭） 默认5000
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //设置打开回路并启动回退逻辑的错误比率。 默认50
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
    })*/
    public Account testTemplate(){
        Account account =feignClient.getAccount();
        log.debug("account :  " + account.toString());
        return account;
    }

    public Account testTemplateFail(){
        Account account = new Account();
        account.setName("访问出错啦");
        return account;
    }
}
