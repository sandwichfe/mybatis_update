package com.lww;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lww.mapper")
public class MybatisFlexApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisFlexApplication.class, args);
    }
}
