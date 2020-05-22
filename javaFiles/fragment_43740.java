@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RollbackException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleRollbackException(RollbackException ex) {

        String errorMessage = "Your custom message";
        return errorMessage ;
    }

}