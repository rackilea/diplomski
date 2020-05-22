@Aspect
@Order(1)
public class CheckParameterAspect {

    @Around("cutPointEmptyParam()")
    public Object checkParameter(ProceedingJoinPoint joinPoint) throws Throwable {
        //...
    }
}

@Aspect
@Order(2)
public class AuthenticateTokenAspect {

    @Around("cutPointToken()")
    public Object authenticateToken(ProceedingJoinPoint joinPoint) throws Throwable {
        //...
    }
}