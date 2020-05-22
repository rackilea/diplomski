@Aspect
@Component
@Order(1)
public class MyAspect {

    private Logger logger = LoggerFactory.getLogger(MyAspect.class);

    @After("execution(* WebController.user(..))")
    public void afterLog() {
        logger.error("Aspect is now logged");
    }
}

@RestControllerAdvice
@Order(2)
public class WebAdvice {

    private Logger logger = LoggerFactory.getLogger(WebAdvice.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handle(RuntimeException e) {
        logger.error("ControllerAdvice is now logged");
    }
}