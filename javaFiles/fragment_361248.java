package de.scrum_master.aspect;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import de.scrum_master.app.MDC;

@Aspect
public class MDCTraceAspect {
  private static final Random RANDOM = new Random(); 
  private Map<String, String> contextMap;
  private Set<Runnable> runnables = new HashSet<>();

  @Pointcut("@annotation(de.scrum_master.app.MDCTrace) && execution(* *(..))")
  private static void entryPoint() {}

  @Before("entryPoint()")
  public void executeEntryPoint() {
    MDC.clear();
    MDC.put("IP", String.valueOf(RANDOM.nextInt()));
    contextMap = MDC.getCopyOfContextMap();
    System.out.println(String.format("[%d] * Entry point", Thread.currentThread().getId()));
  }

  @Before("execution(Runnable+.new(..)) && cflow(entryPoint()) && target(runnable)")
  public void beforeNewRunnable(JoinPoint joinPoint, Runnable runnable) {
    runnables.add(runnable);
    MDC.setContextMap(contextMap);
    System.out.println(String.format("[%d] * New Runnable", Thread.currentThread().getId()));
  }

  @Before("execution(public void Runnable+.run(..)) && target(runnable)")
  public void beforeRunnableExecution(JoinPoint joinPoint, Runnable runnable) {
    if (!runnables.contains(runnable))
      return;
    MDC.setContextMap(contextMap);
    System.out.println(String.format("[%d] * Runnable started", Thread.currentThread().getId()));
  }
}