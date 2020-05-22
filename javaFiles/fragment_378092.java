@Provider
public class EntityNotFoundExceptionMapper 
    implements ExceptionMapper<EntityNotFoundException> {

    @Override
    public Response toResponse(EntityNotFoundException ex) {
      return Response.status(404).entity(ex.getMessage()).type("text/plain").build();
    }
}