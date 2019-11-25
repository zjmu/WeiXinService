package com.example.weichat.util;

import com.example.weichat.config.ApplicationContextRegister;
import com.example.weichat.config.WxMiniProperties;
import org.springframework.web.context.ContextLoader;

/**
 * @author zjm
 * @date 2019/11/17
 */
public class WeiXinPropertiesUtils {
    private static WxMiniProperties miniProperties;
    private static void init() {
        if(miniProperties == null) {
            miniProperties = ApplicationContextRegister.getApplicationContext() .getBean(WxMiniProperties.class);
        }
    }

    public static WxMiniProperties getMiniProperties() {
        init();
        return miniProperties;
    }
}
