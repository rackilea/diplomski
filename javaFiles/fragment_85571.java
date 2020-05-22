@ControllerAdvice
public class GlobalControllerBehavior {

    @ExceptionHandler
    public ResponseEntity handleException(YourException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}