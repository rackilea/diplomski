@ControllerAdvice
public class ValidationAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationError(MethodArgumentNotValidException ex) {
         List<String> validationErrors = ex.getBindingResult()
                                            .getAllErrors()
                                            .stream()
                                            .map(ObjectError::getDefaultMessage)
                                            .collect(Collectors.toList());

         return ResponseEntity.badRequest().body(validatioErrors);
    }
}