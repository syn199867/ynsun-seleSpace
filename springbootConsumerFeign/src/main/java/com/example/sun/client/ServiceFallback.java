package com.example.sun.client;

import com.example.common.entity.RestfulResult;
import com.example.sun.entity.ServiceInfo;
import org.springframework.stereotype.Component;

/**
 * @program: springbootConsumerFeign
 * @description: ServiceFallback
 * @author: ynsun
 * @create: 2022-03-25 10:40
 */


@Component
public class ServiceFallback implements ServiceFeignClient{

    @Override
    public RestfulResult hello(ServiceInfo serviceInfo) {
        RestfulResult result = new RestfulResult();
        result.setData("服务调用失败");
        return result;
    }
}
