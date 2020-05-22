@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(MyException.class)
    public void handleConflict() {
        // Nothing to do
    }
}