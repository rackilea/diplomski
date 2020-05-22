@Aspect
public class ActivityLogger {

    private static final Logger logger = LoggerFactory.getLogger("activity");

    @Pointcut(value = "@annotation(loggableActivity)", argNames = "loggableActivity")
    public void loggableUserActivity(LoggableActivity loggableActivity) {

    }

    @Around("loggableUserActivity(loggableActivity)")
    public Object doLoggingUserActivity(ProceedingJoinPoint pjp,
            LoggableActivity loggableActivity) throws Throwable {}