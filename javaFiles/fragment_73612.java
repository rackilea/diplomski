@Component
@ControllerAdvice
public class LoginErrorHandler{

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public void handleError(HttpClientErrorException e, HttpServletResponse response) throws IOException {
    response.sendError(e.getRawStatusCode(), e.getStatusText());
    }
}