@Aspect
public class FooAspect {

    @Around("@annotation(MarkForProcessing)")
    public void doProcessing(final ProceedingJoinPoint joinPoint) throws Throwable 
    {
        //Do some before processing
        joinPoint.proceed(); //Invokes the underlying method
        //Do some after processing
    }

}