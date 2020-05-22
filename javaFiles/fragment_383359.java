@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(value = VermaException.class)
    @ResponseBody
    public String heightError(VermaException ex) {
        return "error";
    }

}