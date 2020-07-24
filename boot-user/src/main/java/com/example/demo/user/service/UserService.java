package com.example.demo.user.service;


import com.example.demo.user.dao.UserMapper;
import com.example.demo.user.dto.RegisterDTO;
import com.example.demo.user.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean register(RegisterDTO dto){

        String salt = UUID.randomUUID().toString();

        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPasword(DigestUtils.md5DigestAsHex((dto.getPassword()+salt).getBytes()));
        user.setSalt(salt);
        //如果insert成功则返回true,与1相等则返回1
        return 1 == userMapper.insert(user);
    }
}
