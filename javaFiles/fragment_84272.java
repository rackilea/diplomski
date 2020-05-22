@Around("execution(* com.mycontrollerpackage.*.*(..))")
public Object aroundWebMethodE(ProceedingJoinPoint pjp) throws Throwable {      
    String packageName = pjp.getSignature().getDeclaringTypeName();
    String methodName = pjp.getSignature().getName();
    long start = System.currentTimeMillis();
    if(!pjp.getSignature().getName().equals("initBinder")) {
       logger.info("Entering method [" + packageName + "." + methodName +  "]");
    }
    Object output = pjp.proceed();
    long elapsedTime = System.currentTimeMillis() - start;
    if(!methodName.equals("initBinder")) {
       logger.info("Exiting method [" + packageName + "." + methodName + "]; exec time (ms): " + elapsedTime);
    }
    return output;
}