public class APIResponse  {
     int errorCode;
     String description;
     String someInformation;
     // any other information that you want to send back in case of exception.
}


@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    public APIResponse handleConflict(DataIntegrityViolationException exception) {
        APIResponse  response = createResponseFromException(exception);
        return response;
    }
}