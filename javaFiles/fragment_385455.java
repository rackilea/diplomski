@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(MyException.class) 
    public ResponseEntity<String> reponseMyException(Exception e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("my message");
    }
}