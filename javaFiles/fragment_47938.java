@ExceptionHandler(EntityNotFoundException.class) //Made up that exception
@ResponseBody
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public ErrorObject handleException(Exception e) {
    return new ErrorObject(e.getMessage());
}