package com.example.weichat.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.weichat.config.WxMiniProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author zjm
 * @date 2019/11/17
 */
public class WeiXinUtils {
    private static final Logger logger = LoggerFactory.getLogger(WeiXinUtils.class);

    public static JSONObject login(String code) {
        logger.info("------小程序登录方法开始--------");
        WxMiniProperties properties = WeiXinPropertiesUtils.getMiniProperties();
        String url = properties.getInterfaceUrl() + "/sns/jscode2session?appid=" + properties.getAppId() + "&secret=" +
                properties.getAppSecret() + "&js_code=" + code + "&grant_type=authorization_code";
        JSONObject message;
        try {
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url,String.class);
            message = JSON.parseObject(response);
        } catch (Exception e) {
            logger.error("微信服务器请求错误",e);
            message = new JSONObject();
        }
        logger.info("message" + message.toString());
        logger.info("--------小程序登录方法结束-----------");
        return message;
        // 后续, 可获取openid session_key等数据, 以下代码一般放在Service层
        //if (message.get("errcode") != null) {
        //    throw new ValidationException(message.toString());
        //}
        //String openid = message.get("openid").toString();
        //String sessionKey = message.get("session_key").toString();
        //...
    }

    /**方法2
     * 通过encryptedData,sessionKey,iv获得解密信息, 拥有用户丰富的信息, 包含openid,unionid,昵称等
     */
//    public static JSONObject decryptWxData(String encryptedData, String sessionKey, String iv) throws Exception {
//        log.info("============小程序登录解析数据方法开始==========");
//        String result = AesCbcUtil.decrypt(encryptedData, sessionKey, iv, "UTF-8");
//        JSONObject userInfo = new JSONObject();
//        if (null != result && result.length() > 0) {
//            userInfo = JSONObject.parseObject(result);
//        }
//        log.info("result: " + userInfo);
//        log.info("============小程序登录解析数据方法结束==========");
//        return userInfo;
//    }
}
