package sun.filter;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


/**
 * @program: springbootZuul
 * @description: ServiceFilter
 * @author: ynsun
 * @create: 2022-03-28 15:01
 */
@Component
class serviceFilter extends ZuulFilter {

        private static Logger log= LoggerFactory.getLogger(serviceFilter.class);

        @Override
        public String filterType() {
            return "pre";
        }

        @Override
        public int filterOrder() {
            return 0;
        }

        @Override
        public boolean shouldFilter() {
            return true;
        }

        @Override
        public Object run() {
            // filter需要执行的具体操作
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest request = ctx.getRequest();
            String token = request.getParameter("token");
            System.out.println(token);
            if (token == null) {
                log.warn("there is no request token");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                try {
                    ctx.getResponse().getWriter().write("there is no request token");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            log.info("ok");
            return null;
        }
}
