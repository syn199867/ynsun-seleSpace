package com.example.sun.controller;

import com.example.common.entity.RestfulResult;
import com.example.common.utils.CommUtils;
import com.example.sun.entity.ServiceInfo;
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
@RequestMapping(value = "service")
public class ServiceController {

        @RequestMapping(value = "hello")
        public void login(HttpServletRequest request, HttpServletResponse response,
                          @RequestBody ServiceInfo serviceInfo) {

            RestfulResult restfulResult = new RestfulResult();

            try {
                restfulResult.setData("Service1:Welcome " + serviceInfo.getName() + "!");

            } catch (Exception e) {
                e.printStackTrace();
            }

            CommUtils.printDataJason(response, restfulResult);
        }

        @RequestMapping(value = "rest")
        public String rest(@RequestBody ServiceInfo serviceInfo){

            return "Service1:Welcome " + serviceInfo.getName() + " !";
        }


}
