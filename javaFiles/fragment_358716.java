package com.company.*;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class AOPMethodLogger {

    @Around("bean(*Service)")
    public Object timeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object retVal = joinPoint.proceed();
        stopWatch.stop();
        if(stopWatch.getTotalTimeMillis() > 35){
            StringBuffer logMessageStringBuffer = new StringBuffer();
            logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
            logMessageStringBuffer.append(".");
            logMessageStringBuffer.append(joinPoint.getSignature().getName());
            logMessageStringBuffer.append("(");
            logMessageStringBuffer.append(joinPoint.getArgs());
            logMessageStringBuffer.append(")");
            logMessageStringBuffer.append(" execution time: ");
            logMessageStringBuffer.append(stopWatch.getTotalTimeMillis());
            logMessageStringBuffer.append(" ms");
            System.out.println(logMessageStringBuffer.toString());
        }
        return retVal;
    }

}