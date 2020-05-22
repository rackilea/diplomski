@Around("com.xyz.myapp.UserService.createUser()")
public Object userCreationAdvice(ProceedingJoinPoint pjp) throws Throwable {
    //Do something if needed before method execution
    Object retVal = pjp.proceed();
    //Do something if needed after method execution
    return retVal;
}