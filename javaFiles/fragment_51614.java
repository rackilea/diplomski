@Aspect
public class JmsPerformanceLogger extends PerformanceLoggingAspect {
    @Inject
    private LogWriter logWriter;

    @Around("within(@org.springframework.ws.server.endpoint.annotation.Endpoint *)")
    public Object withinAnEndpoint(ProceedingJoinPoint pjp) throws Throwable {
        return proceedWithLogging(pjp, MetingType.BERICHT);
    }
}