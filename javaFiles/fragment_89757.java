package com.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
  @Pointcut("execution(* com.test..*(..) )")
  public void logPointCut() {}

  @Before("logPointCut()")
  public void printBeforeMethodInvoke(JoinPoint joinPoint) {
    System.out.println(joinPoint);
  }
}