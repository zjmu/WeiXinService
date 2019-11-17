package com.example.weichat.controller;

import org.apache.logging.log4j.message.MapMessage;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
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
    @RequestMapping("/login")
    public Map<String, Object> doLogin(Model model,
                                       @RequestParam(value = "code",required = false) String code,
                                       @RequestParam(value = "rawData",required = false) String rawData,
                                       @RequestParam(value = "signature",required = false) String signature,
                                       @RequestParam(value = "encrypteData",required = false) String encrypteData,
                                       @RequestParam(value = "iv",required = false) String iv) {
        logger.info("Start get SessionKey");

        Map<String, Object> map = new HashMap<>();
        System.out.println("用户非敏感信息"+rawData);
        JSONObject rawDataJson = JSON.parseObject(rawData);
        System.out.println("签名"+signature);
        System.out.println("post请求获取的SessionAndopenId="+SessionKeyOpenId);

        String openid = SessionKeyOpenId.getString("openid" );

        String sessionKey = SessionKeyOpenId.getString( "session_key" );

        System.out.println("openid="+openid+",session_key="+sessionKey);

    }

}
