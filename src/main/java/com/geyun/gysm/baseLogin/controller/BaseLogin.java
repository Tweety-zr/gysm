package com.geyun.gysm.baseLogin.controller;

import com.geyun.gysm.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author 崔世良
 * @date 2020/1/19 16:14
 * @editer 崔世良
 * @editdate 2020/1/19 16:14
 * @description
 */
@RestController
@RequestMapping("base")
public class BaseLogin {

    @PostMapping("login")
    public Result login(@RequestParam HashMap<String, Object> param) {
        //账号密码
        String account = "", password = "";
        if (param.containsKey("account")) {
            account = param.get("account").toString();
        }
        if (StringUtils.isBlank(account)) {
            return Result.fail("账号不能为空");
        }
        if (param.containsKey("password")) {
            password = param.get("password").toString();
        }
        if (StringUtils.isBlank(password)) {
            return Result.fail("密码不能为空");
        }
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken uptoken = new UsernamePasswordToken(account, password);
            subject.login(uptoken);
            return Result.success();
        } catch (Exception e) {
            return Result.fail("用户名或密码错误");
        }
    }
}
