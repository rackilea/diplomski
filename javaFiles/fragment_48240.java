@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(corresponding HTTP return value) 
    @ExceptionHandler(SomeException.class)
    public void handleException() {
        // Nothing to do
    }
}