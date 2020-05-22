package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import de.scrum_master.app.MeteredRemoteCall;

@Aspect
public class MetricAspect {
    @Around(value = "@annotation(annotation)", argNames = "joinPoint, annotation")
    public Object meterRemoteCall(ProceedingJoinPoint joinPoint, MeteredRemoteCall annotation)
        throws Throwable
    {
        System.out.println(joinPoint);
        return joinPoint.proceed();
    }
}