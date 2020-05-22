@Aspect
@Component
public class CustomSecurityAspect {
    @Pointcut("@annotation(my.package.CustomSecurityAnnotation)")
    private void customSecurityAnnotation() {
    }

    @Around("my.package.CustomSecurityAspect.customSecurityAnnotation()")
    public Object doSomething(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest req = getRequest();
        // Check header values
        // Throw Spring's AccessDeniedException if needed
        return pjp.proceed();
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return sra.getRequest();
    }
}