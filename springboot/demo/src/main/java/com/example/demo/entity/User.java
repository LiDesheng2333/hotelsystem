package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value="user")
public class User {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String phone;
    private String idcard;

}
