package com.example.demo.user.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterDTO {

    @NotBlank(message = "不能为空")
    private String userName;

    @Length(min = 8, max = 16, message = "密码长度不正确,大于0,小于8")
    private String password;
}
