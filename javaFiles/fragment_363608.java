@ControllerAdvice
public class RestExceptionControllerAdvice {

    @ExceptionHandler(NumberFormatException.class)
    public ErrorResponse handleSearchParseException(NumberFormatException exception) {
       // do whathever you want
   }

}