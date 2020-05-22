@RestController
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UsernameNotFoundException.class, DataAccessException.class)
    @ResponseStatus(HttpStatus.SC_UNAUTHORIZED)
    @ResponseBody ErrorInfo
    UnauthorizeExceptionInfo(HttpServletRequest req, Exception ex) {
        return new ErrorInfo(req.getRequestURL(), ex);
    } 
}