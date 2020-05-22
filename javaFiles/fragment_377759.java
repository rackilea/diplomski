@Around("execution(@Ping * *(..))")
public void entr(ProceedingJoinPoint joinPoint) throws Throwable {
 System.out.println("before method");
 joinPoint.proceed();
 System.out.println("after method");
}