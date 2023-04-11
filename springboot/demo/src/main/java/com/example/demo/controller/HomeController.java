package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.controller.dto.HomeDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.Room;
import com.example.demo.entity.User;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderService orderService;

    @Autowired
    RoomMapper roomMapper;

    @GetMapping
    public HomeDto query(HomeDto homeDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id", 0);
        homeDto.setUserNumber(userMapper.selectCount(queryWrapper));

        QueryWrapper<Order> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.select("sum(money) as saleNumber");
        Order ord= orderService.getOne(queryWrapper1);
        if (ord== null){
            homeDto.setSaleNumber(String.valueOf(0)); ;
        }else{
            homeDto.setSaleNumber(String.valueOf(ord.getSaleNumber()));
        }

        QueryWrapper<Room> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("state", "空");
        homeDto.setEmptyroomNumber(String.valueOf(roomMapper.selectCount(queryWrapper2)));

        QueryWrapper<Room> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.eq("state", "预定");
        homeDto.setPreOrderNumber(String.valueOf(roomMapper.selectCount(queryWrapper3)));
        return homeDto;
    }

}
