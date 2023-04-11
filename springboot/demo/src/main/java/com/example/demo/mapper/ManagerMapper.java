package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Manager;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ManagerMapper extends BaseMapper<Manager> {

}
