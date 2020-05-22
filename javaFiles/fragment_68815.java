package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TxAspect {

    @Around("methodsToBeProfiled()")
    public void test(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("I am not going to do anything");
        pjp.proceed();
    }

    @Pointcut("execution(* com.example.ConcreteClass.abstractMethod(..))")
    public void methodsToBeProfiled(){}
}