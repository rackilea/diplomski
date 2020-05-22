@ControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ErrorResponse errorResponse(BindException ex) {
        return new ErrorResponse("Validation failed", ex.getFieldErrors()
            .stream()
            .map(err -> new SpecificError(err.getField(), err.getDefaultMessage()))
            .collect(Collectors.toList()));
    }
}