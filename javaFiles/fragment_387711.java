@EnableWebMvc
@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HystrixRuntimeException.class)
    @ResponseBody
    ResponseEntity<String> handleControllerException(HttpServletRequest req, Throwable ex) {
        if(ex instanceof HystrixRuntimeException) {
            HttpStatusCodeException exc = (HttpStatusCodeException)ex.getCause();
            return new ResponseEntity<>(exc.getResponseBodyAsString(), exc.getStatusCode());
        }
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}