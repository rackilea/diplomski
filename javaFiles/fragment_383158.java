@ControllerAdvice(annotations = RepositoryRestController.class)
public class GenericExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler
    //if you don't use Exception e in method you can remove it , live only Locale
    public ResponseEntity handle(Exception e, Locale locale) {

            String errorMessage = messageSource.getMessage(
                                 "error.message", new Object[]{},locale);  
            //set message  or return it instead of exceptionMessageObject
            exceptionMessageObject.setMessage(exceptionMessageObject);

            return new ResponseEntity(exceptionMessageObject, 
                   new HttpHeaders(), httpStatus);
    }