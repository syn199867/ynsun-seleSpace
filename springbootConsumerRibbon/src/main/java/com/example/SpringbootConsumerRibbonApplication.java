package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient

/**
 Servlet可以直接通过@WebServlet注解自动注册

 Filter可以直接通过@WebFilter注解自动注册

 Listener可以直接通过@WebListener注解自动注册
 */
@ServletComponentScan
@EnableHystrix
public class SpringbootConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootConsumerRibbonApplication.class, args);
    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }



}
