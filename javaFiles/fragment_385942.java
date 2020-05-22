package aspects;

@Aspect
public class MyAspect {

    @Pointcut("if() && call(public * some.orm.Datastore.get(..)) && args(paramClass,..)")
    public static boolean runBefore(JoinPoint jp, Class paramClass) {
         return paramClass.isAnnotationPresent(annotation.SecureObject.class);
    }

    @Before("runBefore(jp, paramClass)")
    public void runBeforeAdvice(JoinPoint jp, Class paramClass) {
        System.out.println("annotated!");
    }
}