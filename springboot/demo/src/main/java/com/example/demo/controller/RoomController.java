package com.example.demo.controller;


import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Order;
import com.example.demo.entity.Room;
import com.example.demo.entity.User;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.service.OrderService;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    public boolean createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }
    @GetMapping
    public List<Room> findAll() {
        return roomService.list();
    }

    @GetMapping("/{id}")
    public Room query(@PathVariable Integer id) {
        return roomService.getById(id);
    }

    @GetMapping("/edit/{id}")
    public Integer edit(@PathVariable Integer id) {
        return roomService.clearInfo(id);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {



        //退房时生成订单
        QueryWrapper<Room> queryWrapper =new QueryWrapper<>();
        Room deleteRoom = roomService.getById(id);
        Order order = new Order();
        order.setUserid(deleteRoom.getUserid());
        order.setEndtime(deleteRoom.getEndtime());
        order.setCreatetime(deleteRoom.getCreatetime());
        order.setType(deleteRoom.getType());

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String CreateDate = dateFormat.format(deleteRoom.getCreatetime());
//        String EndDate = dateFormat.format(deleteRoom.getCreatetime());
//        Date date1 = DateUtil.parse(CreateDate);
//        Date date2 = DateUtil.parse(EndDate);
        long betweenDay = DateUtil.between(deleteRoom.getCreatetime(), deleteRoom.getEndtime(), DateUnit.DAY);
        Integer money=0;
        if(deleteRoom.getType().equals("单人间")){
            money=(int)betweenDay*80;
        }else if(deleteRoom.getType().equals("双人间")){
            money=(int)betweenDay*120;
        }else if(deleteRoom.getType().equals("豪华间")){
            money=(int)betweenDay*200;
        }
        if(money!=0){
            order.setMoney(money);
            orderMapper.insert(order);
        }

        //清空客房入住与结束时间等

        return roomService.clearInfo(id);
    }


    @GetMapping("/page")
    public IPage<Room> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(defaultValue = "") String userid) {
        IPage<Room> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Room> queryWrapper = new QueryWrapper<>();
        return roomService.page(page, queryWrapper);
    }
}
