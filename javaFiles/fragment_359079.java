@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ ConstraintViolationException.class})
    public ResponseEntity<Map<String, Object>> yourExceptionHandler(ConstraintViolationException e) {
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, String> errors = new HashMap<String, String>();
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();

        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            errors.put(constraintViolation.getPropertyPath().toString() , constraintViolation.getMessage());
        }

        response.put("error", errors);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
    }
}