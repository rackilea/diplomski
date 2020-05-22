@ControllerAdvice(basePackageClasses = RepositoryRestExceptionHandler.class)
public class GlobalExceptionHandler {

    @ExceptionHandler({QueryException.class})
    public ResponseEntity<Map<String, String>> yourExceptionHandler(QueryException e) {
        Map<String, String> response = new HashMap<String, String>();
        response.put("message", "Bad Request");
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST); //Bad Request example
    }
}