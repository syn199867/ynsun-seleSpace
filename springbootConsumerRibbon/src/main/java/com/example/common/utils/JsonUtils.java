package com.example.common.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: demo
 * @description: JsonUtils
 * @author: ynsun
 * @create: 2022-03-09 16:24
 */
public class JsonUtils {
    public JsonUtils() {
    }

    public static String renderString(HttpServletResponse response, Object object) {
        return renderString(response, JsonMapper.toJsonString(object), "application/json");
    }

    public static String renderString(HttpServletResponse response, String string, String type) {
        try {
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
            return null;
        } catch (IOException var4) {
            return null;
        }
    }
}
