package com.example.sun.client;

/**
 * @program: springbootConsumerFeign
 * @description: ServiceFeignClient
 * @author: ynsun
 * @create: 2022-03-25 10:39
 */

import com.example.common.entity.RestfulResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.sun.entity.ServiceInfo;

@Component
@FeignClient(value = "springbootService", fallback=ServiceFallback.class) //这里的value对应调用服务的spring.applicatoin.name
public interface ServiceFeignClient {

    @RequestMapping(value = "/service/hello")
    RestfulResult hello(@RequestBody ServiceInfo serviceInfo);

}
