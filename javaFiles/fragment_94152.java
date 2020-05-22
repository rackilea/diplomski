@Aspect
@Component
@Order(1)
public class MyAspect {

    private Logger logger = LoggerFactory.getLogger(MyAspect.class);

    @After("execution(* WebAdvice.handle(..)) || execution(* WebController.user(..))")
    public void afterLog() {
        logger.error("Aspect is now logged");
    }
}