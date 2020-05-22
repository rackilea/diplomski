@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        LOG.error(exception);
        String bodyOfResponse = exception.getMessage();
        return new ResponseEntity(errorMessage, headers, status);
    }
}