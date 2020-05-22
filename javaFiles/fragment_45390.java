package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.EnclosingStaticPart;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ContractEnforcerAspect {
  @Before("call(* com.dao..*(..))")
  public void beforeAdvice(JoinPoint joinPoint, EnclosingStaticPart enclosingStaticPart) {
    System.out.println("  Callee = " + joinPoint.getSignature());
    System.out.println("  Caller = " + enclosingStaticPart.getSignature());
    if (enclosingStaticPart.getSignature().getDeclaringType().getPackageName().startsWith("com.controller"))
      throw new RuntimeException("DAO must not be called from controller");
  }
}