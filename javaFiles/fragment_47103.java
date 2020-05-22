import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class LogExecutionTime {

    private static final String LOG_MESSAGE_FORMAT = "%s.%s execution time: %dms";
    private static final Logger logger = LoggerFactory.getLogger(LogExecutionTime.class);

    @Pointcut("execution(@LogMe * *(..))")
    public void isAnnotated() {}

    /**
     * Method will add log statement of running time of the methods which are annotated with @LogMe
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("isAnnotated()")
    public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
      StopWatch stopWatch = new StopWatch();
      stopWatch.start();

      Object retVal = joinPoint.proceed();

      stopWatch.stop();

      logExecutionTime(joinPoint, stopWatch);

      return retVal;
    }

    private void logExecutionTime(ProceedingJoinPoint joinPoint, StopWatch stopWatch) {
      String logMessage = String.format(LOG_MESSAGE_FORMAT, joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), stopWatch.getTotalTimeMillis());
      logger.info(logMessage.toString());
    }
}