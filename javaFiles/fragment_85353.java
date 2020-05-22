@ResponseStatus(HttpStatus.CONFLICT)
@ExceptionHandler(DataIntegrityViolationException.class)
@ResponseBody
public RestErrorInfo handleSpringDataConflict() {
     return new RestErrorInfo(HttpStatus.CONFLICT, "database problem");
}