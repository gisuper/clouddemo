package com.cloud.userserver.controllor;

import com.cloud.userserver.pojo.Account;
import com.cloud.userserver.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yangxiong on 2019/8/2.
 */
@RestController
@RequestMapping("/account")
public class controllor {


    @Autowired
    private AccountService accountService;
    @GetMapping("{id}")
    public Account hello(@PathVariable int id){
        System.out.println("hello");
        Account account = accountService.queryById(id);
        return account;
    }

    @GetMapping("/all")
    public List<Account> all(){
        List<Account> accounts = accountService.queryAll( );
        return accounts;
    }
}
