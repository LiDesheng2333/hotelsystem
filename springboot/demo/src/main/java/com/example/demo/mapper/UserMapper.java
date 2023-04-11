package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<User> {


//    @Insert("INSERT INTO user(name,phone,idcard) VALUES (#{name},#{phone},#{idcard})")
//    int insert(User user);
//
//    int update(User user);
//
//
//    @Delete("DELETE FROM user WHERE id= #{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//
//    @Select("SELECT * FROM user LIMIT #{pageIndex},#{pageSize}")
//    List<User> selectPage(Integer pageIndex, Integer pageSize);
//
//
//    @Select("SELECT COUNT(*) FROM user")
//    Integer selectTotal();

}
