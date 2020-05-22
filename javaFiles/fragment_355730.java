@Component
@Aspect
class ControllerAdvice{

     @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
     void hasRequestMappingAnnotation() {}

     @Pointcut("execution(* your.base.package..*Controller.*(..))")
     void isMethodExecution() {}

   /**
    * Advice to be executed if this is a method being executed in a Controller class  within our package structure
    * that has the @RequestMapping annotation.
    * @param joinPoint
    * @throws Throwable
    */
    @Before("hasRequestMappingAnnotation() && isMethodExecution()")
    void beforeRequestMappedMethodExecution(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Intercepted: " + method);

        //Now do whatever you need to
    }
}