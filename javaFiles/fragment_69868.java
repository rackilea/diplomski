package de.scrum_master.aspect;

import java.util.function.Supplier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
  @Before("execution(* *(*)) && args(supplier)")
  public void methodCallWithSupplierArgument(JoinPoint thisJoinPoint, Supplier<?> supplier) throws Exception {
    System.out.println(thisJoinPoint + " -> " + supplier.get());
  }
}