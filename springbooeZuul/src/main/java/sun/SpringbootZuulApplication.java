package sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: springbootZuul
 * @description: SpringbootZuulApplication
 * @author: ynsun
 * @create: 2022-03-28 15:39
 */

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@RefreshScope
public class SpringbootZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootZuulApplication.class, args);
    }

}
