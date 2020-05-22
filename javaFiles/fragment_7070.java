package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
  @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
  private static void requestMapping() {}

  @Pointcut("@within(de.scrum_master.app.LooseController)")
  private static void looseController() {}

  @Before("requestMapping() && looseController()")
  public void myAdvice(JoinPoint thisJoinPoint) {
    System.out.println(thisJoinPoint);
  }
}