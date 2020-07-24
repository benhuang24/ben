package com.example.demo.user.controller;

import com.example.demo.user.dto.RegisterDTO;
import com.example.demo.user.service.UserService;
import com.example.demo.user.vo.result.FailResult;
import com.example.demo.user.vo.result.Result;
import com.example.demo.user.vo.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Valid RegisterDTO dto){
        boolean result = userService.register(dto);
        if (result){
            return new SuccessResult<>();
        } else {
            return new FailResult();
        }
    }
}
