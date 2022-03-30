package com.sun;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @program: springbootEureka
 * @description:ConsumerClientApplication
 * @author: ynsun
 * @create: 2022-03-23 17:19
 */

@SpringBootApplication
@EnableEurekaServer

//能够让注册中心能够发现,扫描到改服务
@EnableDiscoveryClient
public class ConsumerClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerClientApplication.class, args);
    }
}


