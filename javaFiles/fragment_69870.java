package de.scrum_master.aspect;

import java.util.function.Supplier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
  @Before("execution(* *(*)) && args(supplier)")
  public void methodCallWithSupplierArgument(JoinPoint thisJoinPoint, Supplier<?> supplier) throws Exception {
    System.out.println(thisJoinPoint + " -> " + supplier.get());
  }

  @AfterReturning(pointcut = "call(public * java.util.function.Supplier+.get())", returning = "result")
  public void supplierEvaluated(JoinPoint thisJoinPoint, Object result) throws Exception {
    System.out.println(thisJoinPoint + " -> " + result);
  }
}