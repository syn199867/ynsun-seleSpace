package com.example.sun.controller;

import com.example.common.entity.RestfulResult;
import com.example.common.utils.CommUtils;
import com.example.sun.client.ServiceFeignClient;
import com.example.sun.entity.ServiceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    ServiceFeignClient serviceFeignClient;

    // 调用：localhost:6004/consumerService?token=1
    @RequestMapping("/consumerService")
    public void consumerService(HttpServletRequest request, HttpServletResponse response,
                                @RequestBody ServiceInfo serviceInfo){

        RestfulResult restfulResult =  serviceFeignClient.hello(serviceInfo);

        CommUtils.printDataJason(response, restfulResult);

        }


}
