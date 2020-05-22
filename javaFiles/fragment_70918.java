@ControllerAdvice
public class TestAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object exceptionHandler(Exception e) {
        return new HttpEntity<>(e.getMessage());
    }
}