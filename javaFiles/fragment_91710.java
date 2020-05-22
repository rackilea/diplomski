@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        //here you can use api of MethodArgumentNotValidException to do anything you want
        //e.getBindingResult(),e.getFieldErrors(),etc;
        // you can change the return type of Object
    }