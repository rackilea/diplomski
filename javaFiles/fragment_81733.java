package com.riapriority.test;

import java.text.MessageFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EatingAspect {
    @Pointcut("call(void Banana.eat()) && target(banana)")
    public void eatCall(Banana banana) {
    }

    @Pointcut("@withincode(CanEat)")
    public void canEat() {
    }

    @AfterReturning("eatCall(banana) && canEat()")
    public void whereEaten(Banana banana,
                           JoinPoint.EnclosingStaticPart thisEnclosingStaticPart) {
        System.out.println(MessageFormat.format("Banana {0} eaten by {1}", banana.getBananaId(),
                thisEnclosingStaticPart.getSignature()));
    }

    @Before("eatCall(banana) && !canEat()")
    public void forbidEating(Banana banana,
                             JoinPoint.EnclosingStaticPart thisEnclosingStaticPart) {
        throw new IllegalStateException(MessageFormat.format("Can''t eat {0} by {1}", banana.getBananaId(),
                thisEnclosingStaticPart.getSignature()));
    }
}