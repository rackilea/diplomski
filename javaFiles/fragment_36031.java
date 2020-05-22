@Around("@within(transactional)")
public Object myMethod(ProceedingJoinPoint pjp, Transactional transactional) throws Throwable {
    boolean readOnly = transactional.readOnly();
    ...
    return pjp.proceed();
}