@Aspect
@Order(1)
public class SpringAspect {

    @Pointcut("within(com.vanilla.service.MyService+)")
    public void businessLogicMethods(){}

     @Around("businessLogicMethods()")
     public Object profile(ProceedingJoinPoint pjp) throws Throwable {
             System.out.println("running Advice #1");   
         Object output = pjp.proceed();
         return output;
     }
}

@Aspect
@Order(2)
public class SpringAspect2 {

    @Pointcut("within(com.vanilla.service.MyService+)")
    public void businessLogicMethods(){}

     @Around("businessLogicMethods()")
     public Object profile(ProceedingJoinPoint pjp) throws Throwable {
             System.out.println("running Advice #2");   
         Object output = pjp.proceed();
         return output;
     }
}