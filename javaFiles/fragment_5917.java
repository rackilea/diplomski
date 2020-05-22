@Around("execution(* execute(..))")
public Object execute(ProceedingJoinPoint pjp) throws Throwable
{
    // Log statements before the call;

    Object obj = pjp.proceed();

    // Log statements after the call;

    return obj;
}