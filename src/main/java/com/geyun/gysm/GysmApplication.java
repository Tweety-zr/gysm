package com.geyun.gysm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.geyun.gysm.*.mapper","/mapper/*/*.xml"})
@SpringBootApplication
public class GysmApplication {

    public static void main(String[] args) {
        SpringApplication.run(GysmApplication.class, args);
    }

}
