package de.scrum_master.aspect;

import java.awt.Color;

import javax.swing.JLabel;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class RedLabelAspect {
    @Pointcut("execution(static javax.swing.JLabel[] createMultiLabel(..))")
    public void multilabelCreation() {}

    @Around("multilabelCreation()")
    public JLabel[] changeLabelColours(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        JLabel[] labels = (JLabel[]) thisJoinPoint.proceed();
        for (JLabel label : labels)
            label.setForeground(Color.RED);
        return labels;
    }
}