package com.example.sun.controller;

import com.example.common.entity.RestfulResult;
import com.example.common.utils.CommUtils;
import com.example.sun.entity.ServiceInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @program: demo
 * @description: ServiceController
 * @author: ynsun
 * @create: 2022-03-09 16:05
 */

@RestController // 重要，如果用Controller会404
public class ServiceController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    String port;


        @RequestMapping(value = "/consumerServiceRibbon")
        @HystrixCommand(fallbackMethod = "consumerRibonServiceFallBack")
        public String consumerRibonService(@RequestBody ServiceInfo serviceInfo) {

            String result = this.restTemplate.postForObject("http://springbootService/service/rest?token=1",serviceInfo,String.class);
            return  result;

        }

    public String consumerRibonServiceFallBack(@RequestBody ServiceInfo serviceInfo) {

            return "调用consumerRibonService异常，端口是："+ port + "，name是：" + serviceInfo.getName() + ".";
        }


}
