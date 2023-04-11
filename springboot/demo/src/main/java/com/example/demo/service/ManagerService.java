package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.controller.dto.ManagerDto;
import com.example.demo.entity.Manager;
import com.example.demo.entity.User;
import com.example.demo.mapper.ManagerMapper;
import com.example.demo.utils.TokenUtils;
import org.springframework.stereotype.Service;

@Service
public class ManagerService extends ServiceImpl<ManagerMapper, Manager> {

    public ManagerDto login(ManagerDto managerDto) {

        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", managerDto.getName());
        queryWrapper.eq("password", managerDto.getPassword());
        Manager one = getOne(queryWrapper);
        if (one != null) {
           String token= TokenUtils.genToken(one.getId().toString(), one.getPassword());
            managerDto.setToken(token);
            managerDto.setFlag(1);
        }else {
            managerDto.setFlag(0);
        }
        return managerDto;
    }

    public Integer verify(String name) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        Manager one = getOne(queryWrapper);
        return one.getRoot();
    }

    public boolean saveManager(Manager manager) {
        return saveOrUpdate(manager);
    }
}
