package com.example.weichat.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.weichat.util.WeiXinUtils;
import org.apache.logging.log4j.message.MapMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;


/**
 * @author zjm
 * @date 2019/11/17
 */
@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @GetMapping("/login")
    public JSONObject doLogin(@RequestParam("code")String code) {
        return WeiXinUtils.login(code);
    }

}
