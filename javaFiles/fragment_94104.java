package de.scrum_master.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
  @Pointcut("execution(* org.group.Person.getList(..))")
  public void methodGetList() {}

  @Pointcut("execution(* org.group.Person.method1(..)) && args(id, *)")
  public void methodMethod1(String id) {}

  @AfterReturning(
    pointcut = "methodGetList() && cflow(methodMethod1(id))",
    returning = "result"
  )
  public void afterMethodGetList(JoinPoint joinPoint, String id, List<String> result) {
    System.out.println(
      "I can see the list result " + result +
      " for the person with id " + id
    );
  }
}