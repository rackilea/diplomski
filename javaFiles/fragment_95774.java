@Aspect
public class ServiceAspect{

    @Pointcut("execution(* foo.bar.service.*.*(..))")
    public void serviceMethodExecution(){
    }

    @Around(value = "serviceMethodExecution() && args(param1, param2)")
    public void aroundServiceMethodExecution(final ProceedingJoinPoint pjp,
        final String param1,
        final Integer param2) throws Throwable{

        System.out.println("Before thing: " + param1 + ", before thang: "
            + param2);
        pjp.proceed();
        System.out.println("After thing: " + param1 + ", after thang: "
            + param2);
    }

}