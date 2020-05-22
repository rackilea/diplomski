@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(MethodArgumentNotValidException.class)
public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    //get All errors with
    ex.getBindingResult().getAllErrors();
    //and map them
}