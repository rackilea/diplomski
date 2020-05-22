@AfterReturning(
    pointcut = "execution(* com.personal.services.Example.buildList(..))",
    returning = "retVal"
)
public void afterReturning(JoinPoint joinPoint, Object retVal) {
    if (retObject != null) {
        logger.error("Returned object: " + retVal);
        logger.error("Returned type:   " + retVal.getClass().getName());
    }
}