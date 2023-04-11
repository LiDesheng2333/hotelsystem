package com.example.demo.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    public boolean saveUser(User user) {
      return saveOrUpdate(user);
    }





//    @Autowired
//    private UserMapper userMapper;
//
//
//    public int  save(User user) {
//        if (user.getId() == null) {      //新增数据
//          return   userMapper.insert(user);
//        }else{                           //更新数据
//          return   userMapper.update(user);
//        }
//    }

}
