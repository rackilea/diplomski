package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAspect {
    @Around(
        "execution(* de.scrum_master.app.Parent+.*(..)) && " +
        "@this(de.scrum_master.app.MyAnnotation)"
    )
    public Object myAdvice(ProceedingJoinPoint thisJoinPoint) {
        System.out.println(thisJoinPoint);
        System.out.println("  " + thisJoinPoint.getThis());
        return thisJoinPoint.proceed();
    }
}