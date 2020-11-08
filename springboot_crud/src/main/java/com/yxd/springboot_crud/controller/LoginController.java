package com.yxd.springboot_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "user/login")
    //@RequestMapping(value = "user/login" ,method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Map<String,Object> map
                            , HttpSession HttpSession){

        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            //登录成功,防止重复提交表单，设置重定向
            HttpSession.setAttribute("loginuser",username);
        return "redirect:/main";

        }else{
            //登录失败
        map.put("msg","用户名或密码错误！");
        return "index";
        }

    }
}
