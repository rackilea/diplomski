@Aspect
public class SomeAspect {

    @Around("execution(void org.luc.Something.doWhatever())")
    void around(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println(pjp.getThis().toString() + ": I've been advised");
    }
}