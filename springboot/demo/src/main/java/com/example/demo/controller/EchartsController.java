package com.example.demo.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Week;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/echarts")
public class EchartsController {


    @Autowired
    OrderService orderService;

    @GetMapping
    public ArrayList<Integer> findAll() {
        List<Order> orders = orderService.list();
        int mon = 0;
        int tue = 0;
        int wed = 0;
        int thu = 0;
        int fri = 0;
        int sat = 0;
        int sun = 0;
        for (Order order : orders) {
            Date createtime = order.getCreatetime();
            Week week = DateUtil.dayOfWeekEnum(createtime);
            switch (week) {
                case MONDAY:
                    mon += 1;
                    break;
                case TUESDAY:
                    tue += 1;
                    break;
                case WEDNESDAY:
                    wed += 1;
                    break;
                case THURSDAY:
                    thu += 1;
                    break;
                case FRIDAY:
                    fri += 1;
                    break;
                case SATURDAY:
                    sat += 1;
                    break;
                case SUNDAY:
                    sun += 1;
                    break;
                default:
                    break;
            }
        }
        return CollUtil.newArrayList(mon,tue,wed,thu,fri,sat,sun);
    }


}
