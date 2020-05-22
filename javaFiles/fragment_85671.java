@Provider
public class SomeAdHocExceptionMapper implements ExceptionMapper<SomeAdHocException> {

    private final GenericExceptionMapper mapper = new GenericExceptionMapper();

    public Response toResponse(SomeAdHocException e) {
        return mapper.toResponse(new GenericException(e));
    }
}