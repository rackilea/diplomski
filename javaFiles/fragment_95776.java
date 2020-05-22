@Pointcut(value = "execution(* foo.bar.service.*.*(..)) && args(a,b)",
          argNames = "a,b")
public void serviceMethodExecution(final String a, final Integer b){
}

@Around(value = "serviceMethodExecution(param1, param2)",
        argNames = "param1,param2")
public void aroundServiceMethodExecution(final String param1,
    final Integer param2,
    final ProceedingJoinPoint pjp) throws Throwable{

    System.out.println("Before thing: " + param1 + ", before thang: "
        + param2);
    pjp.proceed();
    System.out.println("After thing: " + param1 + ", after thang: "
        + param2);
}