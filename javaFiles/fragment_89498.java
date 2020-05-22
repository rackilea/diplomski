@EnableWebMvc
@ControllerAdvice
public class GenericRepositoryRestExceptionHandler{

    @Autowired
    MessageSource messageSource;

    @ResponseBody
    @ExceptionHandler
    ResponseEntity<?> handleConflict(DataIntegrityViolationException e) {
        return response(HttpStatus.CONFLICT, 40901, "Operation cannot be performed. Integrity Constraint violated", e.getRootCause().getMessage(), "");
    }

    @ResponseBody
    @ExceptionHandler(InconsistentEditException.class)
    ResponseEntity<?> handleInconsistentEditException(InconsistentEditException e){
        return response(HttpStatus.CONFLICT, 40902, e.getMessage());
    }

    private ResponseEntity<RestError> response(HttpStatus status, int code, String msg) {
        return response(status, code, msg, "", "");
    }

    private ResponseEntity<RestError> response(HttpStatus status, int code, String msg, String devMsg, String moreInfo) {
        return new ResponseEntity<>(new RestError(status.value(), code, msg, devMsg, moreInfo), status);
    }
}