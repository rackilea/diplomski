package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ErrorHandler {

  @Around("execution(String *(..))")
  public String handleErrors(ProceedingJoinPoint thisJoinPoint) throws Throwable {
    try {
      return (String) thisJoinPoint.proceed();
    } catch (Exception e) {
      System.out.println("Exception handled: " + e);
      return "dummy";
    }
  }
}