@Provider 
public class ConstraintViolationExceptionMapper 
        implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        ...
    } 
}