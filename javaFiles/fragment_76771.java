@ControllerAdvice
public class DefaultExceptionHandler {

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(MyException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody Map<String, Object>
        handleMyException(MyException ex) {

        return MyUtil.mapOf("exception", "MyException",
                "message", ex.getMessage());
    }