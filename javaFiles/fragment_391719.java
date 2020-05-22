public class ThrowableMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable throwable) {
        return Response.status(500).entity("{ \"message\": \"" + throwable.getMessage() + "\" }").build();
    }

}