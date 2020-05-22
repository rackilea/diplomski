@Provider
public class MethodConstraintViolationExceptionMapper extends MyBaseExceptionMapper
        implements ExceptionMapper<MethodConstraintViolationException>
{
    @Override
    public Response toResponse(MethodConstraintViolationException exception) 
    {
        //Do Something with the errors here and create a response.
    }
}