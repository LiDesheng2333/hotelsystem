package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value="orders")
public class Order {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer userid;
    private Integer money;
    private Date createtime;
    private Date endtime;
    private String type;

    @TableField(exist = false)
    private Integer saleNumber;
}
