package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value="room")
public class Room {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer userid;
    private Date createtime;
    private String type;
    private Date endtime;
    private String state;
    private String food;
}
