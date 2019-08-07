package com.cloud.consumerdemo.feignclient;

import com.cloud.consumerdemo.pojo.Account;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by yangxiong on 2019/8/7.
 */
@FeignClient(name ="user-server")
public interface ConsumerFeignClient {

    @GetMapping("/account/1")
    Account getAccount();
}
