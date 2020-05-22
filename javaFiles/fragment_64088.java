package com.mycompany;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The purpose of this class is to emulate the Spring 4 annotation @CORSFilter - using the power of Spring 3
 * Note that is is constrained to non-prod environments
 */
public class Spring3CorsFilterHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // Test if the controller-method is annotated with @Spring3CORSFilter
            Spring3CorsFilter filter = handlerMethod.getMethod().getAnnotation(Spring3CorsFilter.class);
            if (filter != null ) {
                // ... do the filtering
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
            }
        }
        return true;
    }
}