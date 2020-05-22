package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.bind.annotation.RequestMapping;

public aspect RequestMappingInterceptor {
    @Pointcut(
        "within(@org.springframework.stereotype.Controller *) && " +
        "@annotation(requestMapping) && " +
        "execution(* *(..))"
    )
    public void controller(RequestMapping requestMapping) {}

    @Before("controller(requestMapping)")
    public void advice(RequestMapping requestMapping, JoinPoint thisJoinPoint) {
        System.out.println(thisJoinPoint);
        System.out.println("  " + requestMapping);
        System.out.println("  " + requestMapping.method()[0]);
    }
}