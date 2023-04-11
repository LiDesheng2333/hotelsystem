package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Room;
import com.example.demo.entity.User;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends ServiceImpl<RoomMapper, Room> {
    public boolean createRoom(Room room) {
        return saveOrUpdate(room);
    }

    @Autowired
    RoomMapper roomMapper;
    public Integer clearInfo(Integer id){
        UpdateWrapper<Room> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id).set("createtime", null);
        updateWrapper.eq("id",id).set("endtime", null);
        updateWrapper.eq("id",id).set("state","空");
        updateWrapper.eq("id",id).set("food",null);
        updateWrapper.eq("id",id).set("userid",null);
        roomMapper.update(null, updateWrapper);
        return roomMapper.update(null, updateWrapper);
    }


}
