@Slf4j
@ControllerAdvice
public class ClientExceptionHandler {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<String> handleRecordNotFoundException(
            RecordNotFoundException e,
            WebRequest request) {

        LogError logging = new LogError("RecordNotFoundException",
                HttpStatus.NOT_FOUND, 
                request.getDescription(true));
        log.info(logging.toJson());

        HttpErrorResponse response = new HttpErrorResponse(logging.getStatus(), e.getMessage());
        return new ResponseEntity<>(response.toJson(),
                HeaderFactory.getErrorHeaders(),
                response.getStatus());
    }
   ....
}