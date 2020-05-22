@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    // .. other handlers..

    @ExceptionHandler({ BusinessException.class })
    public ResponseEntity<Object> handleBusinessException(BusinessException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getError());
    }

}