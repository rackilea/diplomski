package de.scrum_master.aspect;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import de.scrum_master.app.MyStructure;

@Aspect("pertarget(execution(de.scrum_master.app.MyStructure.new(..)))")
public class LocksAspect {
  private static final long startTime = System.currentTimeMillis();

  private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  private Lock readLock = readWriteLock.readLock();
  private Lock writeLock = readWriteLock.writeLock();

  @Around("target(myStructure) && execution(void insert(String))")
  public void InsertPointcutBefore(ProceedingJoinPoint thisJoinPoint, MyStructure myStructure) throws Throwable {
    writeLock.lock();
    log("entering write section", myStructure);
    try {
      Thread.sleep(1000);
      thisJoinPoint.proceed();
    } finally {
      log("exiting write section", myStructure);
      writeLock.unlock();
    }
  }

  @Around("target(myStructure) && execution(void read(int))")
  public void ReadPointcutBefore(ProceedingJoinPoint thisJoinPoint, MyStructure myStructure) throws Throwable {
    readLock.lock();
    log("entering read section", myStructure);
    try {
      Thread.sleep(1000);
      thisJoinPoint.proceed();
    } finally {
      log("exiting read section", myStructure);
      readLock.unlock();
    }
  }

  private static void log(String message, Object targetObject)  {
    System.out.printf(
      "%8d ms | %-25s | %-17s | %s%n",
      System.currentTimeMillis() - startTime,
      Thread.currentThread(),
      targetObject,
      message
    );
  }
}