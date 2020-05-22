@ControllerAdvice
public class RestErrorHandler {
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "INTERNAL_SERVER_ERROR")
    @ExceptionHandler(Exception.class)
    public void handleConflict(Exception e) {
        // log me
    }
}