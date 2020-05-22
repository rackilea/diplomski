package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import de.scrum_master.app.Authorized;

@Aspect
public class MyAspect {
    @Before("@annotation(authorized) && execution(* *(..)) && !execution(* *(.., Integer))")
    public void authorize(JoinPoint joinPoint, Authorized authorized) {
        System.out.println(joinPoint);
    }
}