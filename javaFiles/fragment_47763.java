@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseEntity<OwnError> handleGenericError(final NullPointerException exception) {

        OwnError ownError=new OwnError();
        ownError.set...

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ownError);
    }
}