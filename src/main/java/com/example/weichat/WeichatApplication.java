package com.example.weichat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class WeichatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeichatApplication.class, args);
    }

}
