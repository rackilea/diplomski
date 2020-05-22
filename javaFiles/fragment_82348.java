package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestCallLogger {
  @Pointcut("within(de.scrum_master..*) && @target(org.springframework.web.bind.annotation.RestController)")
  public void restControllers() {}

  @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
  public void requestMappingAnnotations() {
  }

  @Around("requestMappingAnnotations()")
  public Object onExecute(ProceedingJoinPoint jp) throws Throwable {
    System.out.println(jp);
    Object result = null;
    try {
      result = jp.proceed();
    } catch (Exception ex) {
      throw ex;
    }
    return result;
  }
}