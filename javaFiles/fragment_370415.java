package com.company.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.company.app.MyAnnotation;

@Aspect
public class MyAspect {
  @Before("@args(com.company.app.MyAnnotation, ..)")
  public void myBeforeAdvice(JoinPoint thisJoinPoint) {
    System.out.println("Before " + thisJoinPoint);
  }

  @After("@args(myAnnotation, ..)")
  public void myAfterAdvice(JoinPoint thisJoinPoint, MyAnnotation myAnnotation) {
    System.out.println("After " + thisJoinPoint + " -> " + myAnnotation);
  }
}