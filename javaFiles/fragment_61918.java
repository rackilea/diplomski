package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import de.scrum_master.app.Log;

@Aspect
public class LoggingAspect {
    int count = 0;

    @Before("execution(* *..Application.calcFibonacci(int)) && @annotation(log)")
    public void measure(JoinPoint thisJoinPoint, Log log) {
        System.out.println(thisJoinPoint + " - " + ++count);
    }
}