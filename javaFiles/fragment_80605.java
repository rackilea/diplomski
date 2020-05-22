@Aspect
public class PerformanceMonitorAspect {

    /**
     * Decide whether the Pointcut to be executed or not
     */
    private static boolean enabled;

    @Pointcut("execution(* com.company.MyService+.*(..)) && if()")
    public static boolean pointCut() {
        return enabled;
    }

    private Logger logger = LoggerFactory.getLogger("performance");

    @Around("pointCut()")
    public Object profileServiceMethods(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        MethodSignature ms = (MethodSignature) thisJoinPoint.getSignature();
        Method m = ms.getMethod();
        long t1 = System.nanoTime();
        Object result = thisJoinPoint.proceed();
        long t2 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t2 - t1);
        if (millis < 1000) {
            logger.trace("Execution time for {}: {} ms", m.getName(), millis);
        } else {
            logger.warn("Substantial execution time for {}: {} ms", m.getName(),
                    millis);
        }
        return result;
    }

    //The value is retrieved by Spring having read a config file written by Maven, depending on the profile
    @Value("${enable.performance.monitor}")
    public void setEnabled(boolean value) {
        enabled = value;
    }

}