@Aspect
public class MyLogger {

    private Logger log = Logger.getLogger(getClass());

    @After("execution(* com.example.web.HomeController.*(..))")
    public void log(JoinPoint point) {
        log.info(point.getSignature().getName() + " called...");
    }
}