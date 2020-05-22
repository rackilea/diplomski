@EnableWebMvc
@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandling.class);


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = InvalidAcceptLanguageException.class)
    @ResponseBody
    public OperationsErrorBean invalidAcceptLanguageException(final HttpServletRequest request, final Exception ex) {
        return errorResponse("N/A", "Accept-Language is not in correct format", "", request.getRequestURI(),
                request.getAttribute("startTime").toString());
    }
}