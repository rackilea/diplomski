@Provider
public class DebugExceptionMapper implements ExceptionMapper<Throwable> {

    @Overrride
    public Response toResponse(Throwable e) {
        e.printStackTrace();
        return Response.serverError()
           .entity(e.getMessage())
           .build();
    }
}