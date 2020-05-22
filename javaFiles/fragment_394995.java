@Provider
public class UserNotFoundMapper implements ExceptionMapper<UserNotFoundException> {
    @Override
    public Response toResponse(UserNotFoundException e) {
        return Response.status(404).entity(e.getMessage()).type("text/plain").build();
    }
}