package com.cloud.consumerdemo.feignclient;

import com.cloud.consumerdemo.pojo.Account;

import org.springframework.stereotype.Component;

/**
 * Created by yangxiong on 2019/8/7.
 */
@Component
public class FeignClientFallback implements ConsumerFeignClient {
    @Override
    public Account getAccount() {
        Account account = new Account();
        account.setName("feign 访问出错！！！");
        return account;
    }
}
