package com.cloud.userserver.service;


import com.cloud.userserver.mapper.AccountMapper;
import com.cloud.userserver.pojo.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by yangxiong on 2019/8/5.
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;


    public Account queryById(int id){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace( );
        }
        Account account = accountMapper.selectByPrimaryKey(id);
        return account;
    }

    public List<Account> queryAll(){
        return accountMapper.selectAll();
    }

    @Transactional
    public void insert(Account account){
        accountMapper.insert(account);
    }

}
