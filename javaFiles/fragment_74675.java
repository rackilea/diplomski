package com.XXXXXXXX.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    private final static String DOMAIN = "XXXXXXXX";

    private static String getCurrentUser() {
        String username = "Unknown";
        try {
            Object principal = SecurityContextHolder.getContext().
                    getAuthentication().
                    getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
        } catch (Exception e) {
        }
        return username;
    }

    @Pointcut("within(com.XXXXXXXX.services..*)")
    public void inServiceLayer() {
    }

    @Pointcut("execution(* getMatcherInfo(..)) || execution(* resetCounter(..))")
    public void notToAdvise() {
    }

    @Around("com.XXXXXXXX.aspects.LoggerAspect.inServiceLayer() && !com.XXXXXXXX.aspects.LoggerAspect.notToAdvise()")
    public Object doLogging(ProceedingJoinPoint pjp)
            throws Throwable {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder(DOMAIN);
        sb.append('/').
                append(getCurrentUser()).
                append(" accessing ").
                append(pjp.getSignature().
                getDeclaringTypeName()).
                append('.').
                append(pjp.getSignature().
                getName());
        log.trace("START: " + sb.toString());
        Object retVal = pjp.proceed(pjp.getArgs());
        long duration = System.nanoTime() - start;
        log.trace("STOP: " + duration / 1000000 + " msec. " + sb.toString());
        return retVal;
    }
}