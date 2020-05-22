package com.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Aspects {
    @After("execution(* com.spring.Aspects.*(..))")
    public void logAfterExecutionAdvice(){
        System.out.print("In After Advice ");
    }
}