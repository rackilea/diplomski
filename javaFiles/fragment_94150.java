@RestController
public class WebController {
    @GetMapping("/user")
    public String user() {
        throw new IllegalArgumentException("my bad");
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