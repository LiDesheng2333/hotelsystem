package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Order;
import com.example.demo.entity.Room;
import com.example.demo.entity.User;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> findAll() {
        return orderService.list();
    }


    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return orderService.removeById(id);
    }

    @GetMapping("/{id}")
    public Order query(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @GetMapping("/page")
    public IPage<Order> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(defaultValue = "") String userid) {
        IPage<Order> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        if (!"".equals(userid)) {
            queryWrapper.like("userid", userid);
        }
        queryWrapper.orderByDesc("id");
        return orderService.page(page, queryWrapper);
    }
}
