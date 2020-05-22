@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(RuntimeException.class)
@ResponseBody
public ErrorResponse errorResponse(RuntimeException ex) {
    return new ErrorResponse(ex.getMessage(), null);
}