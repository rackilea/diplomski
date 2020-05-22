@Slf4j
@ControllerAdvice
public class InternalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException e,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        LogError error = new LogError("MissingServletRequestParameterException", 
                HttpStatus.BAD_REQUEST,
                String.format("Missing '%s' parameter", e.getParameterName()));
        log.debug(error.toJson());

        HttpErrorResponse response = new HttpErrorResponse(error.getStatus(), e.getMessage());
        return new ResponseEntity<>(response.toJson(),
                HeaderFactory.getErrorHeaders(),
                response.getStatus());
    }

    ....
}