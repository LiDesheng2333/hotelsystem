package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.controller.dto.ManagerDto;
import com.example.demo.entity.Manager;
import com.example.demo.entity.User;
import com.example.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

        @GetMapping
    public List<Manager> findAll() {
        return managerService.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return managerService.removeById(id);
    }
    @PostMapping("/save")
    public boolean save(@RequestBody Manager manager) {
        return managerService.saveManager(manager);
    }



    @PostMapping("/login")
    public ManagerDto login(@RequestBody ManagerDto managerDto) {
        //非空校验

        return managerService.login(managerDto);
    }

    @GetMapping("/verify")
    public Integer flag(String name) {

        return managerService.verify(name);

    }
}
