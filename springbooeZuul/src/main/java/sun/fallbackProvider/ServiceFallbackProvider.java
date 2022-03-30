package sun.fallbackProvider;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: springbootZuul
 * @description: ServiceFallbackProvider
 * @author: ynsun
 * @create: 2022-03-28 15:00
 */

@Component
public class ServiceFallbackProvider implements FallbackProvider {
    @Override
    // 指定熔断器功能应用于哪些路由的服务
    public String getRoute() {
        // 这里只针对"springbootService"服务进行熔断
        // 如果需要针对所有服务熔断，则return "*"
        return "springbootService";
    }

   @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {

        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "ok";
            }

            @Override
            public void close() {

            }

            @Override
            // 发生熔断式，返回的信息
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("Sorry, the service is unavailable now.".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return null;
    }
}
