@Around("anyPublicMethod() && @annotation(myAnnotation )")
public Object myAspect(final ProceedingJoinPoint pjp,
    final MyAnnotation myAnnotation) throws Throwable{

    // retrieve the methods parameter types (static):
    final Signature signature = pjp.getStaticPart().getSignature();
    if(signature instanceof MethodSignature){
        final MethodSignature ms = (MethodSignature) signature;
        final Class<?>[] parameterTypes = ms.getParameterTypes();
        for(final Class<?> pt : parameterTypes){
            System.out.println("Parameter type:" + pt);
        }
    }

    // retrieve the runtime method arguments (dynamic)
    for(final Object argument : pjp.getArgs()){
        System.out.println("Parameter value:" + argument);
    }

    return pjp.proceed();
}