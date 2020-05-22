@Around("execution(public * *(..)) && @annotation(org.springframework.transaction.annotation.Transactional)")
    public Object myMethod(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();

        Transactional annotation = method.getAnnotation(org.springframework.transaction.annotation.Transactional.class);
        boolean value = annotation. readOnly();
        ...
        return pjp.proceed();
    }