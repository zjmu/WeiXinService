package com.example.weichat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zjm
 * @date 2019/11/17
 */
@Data
@Component
@ConfigurationProperties(prefix = "luwei.model.wx-mini")
public class WxMiniProperties {

    private String appId;
    private String appSecret;
    private String interfaceUrl;
}
