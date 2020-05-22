@Aspect
final class PerformanceAdvice extends AbstractPerformanceAdvice {
    @Override
    void externalPointcut(){}
}

@Aspect
public abstract class AbstractPerformanceAdvice {
    private Logger logger = LoggerFactory.getLogger("perfLogger");

    @Pointcut
    abstract void externalPointcut();

    @Around("externalPointcut()")
    public Object log(final ProceedingJoinPoint call) throws Throwable {
        logger.info("Logging statistics.");
    }
}