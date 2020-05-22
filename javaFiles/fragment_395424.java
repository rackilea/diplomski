package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SecuredAPIAspect {
  @Around("@withincode(de.scrum_master.app.SecuredAPI) && call(* setQuery(..))")
  public Object myAdvice(ProceedingJoinPoint thisJoinPoint) throws Throwable {
    System.out.println(thisJoinPoint);
    return thisJoinPoint.proceed();
  }
}