package sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @program: springbootConfig
 * @description: ConsumerClientApplication
 * @author: ynsun
 * @create: 2022-03-24 10:00
 */


@SpringBootApplication
//能够发现注册
@EnableConfigServer
//配置更新
public class ConsumerClientApplication {

    public static void main(String[] args){
        SpringApplication.run(ConsumerClientApplication.class,args);
    }
}
