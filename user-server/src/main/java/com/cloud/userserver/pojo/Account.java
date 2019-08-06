package com.cloud.userserver.pojo;


import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Created by yangxiong on 2019/8/1.
 */
@Data
@Table(name = "account")
public class Account {
    @Id
    private Integer id;
    private String name;
    private Double money;
}
