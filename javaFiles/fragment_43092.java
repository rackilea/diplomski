package org.myDomain.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.myDomain.app.Utils;

@Aspect
public class Logger {
    @Pointcut("execution(* org.myDomain..*(..))")
    public void selectAll() {}

    @Pointcut("cflow(within(Logger))")
    public void codeWithinAspect() {}

    @Before("selectAll() && !codeWithinAspect()")
    public void advice(JoinPoint joinPoint) {
        Utils.printToConsole(joinPoint);
    }
}