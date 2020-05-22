@ControllerAdvice
public class ControllerAdvice {

   @ExceptionHandler(PersonNotFoundException.class) 
   public ResponseEntity <VndErrors > notFoundException(final PersonNotFoundException e) {

    return error(e, HttpStatus.NOT_FOUND, e.getId().toString());

   }

}