@Provider
public class ExampleExceptionMapper implements ExceptionMapper<ExampleException>  {
    @Context UriInfo info;         
    @Override
    public Response toResponse(ExampleException ex) {
        if (info.getPathParameters().isEmpty())) //please make better condition based on your needs
           return Response.status(Status.BAD_REQUEST).build();
        else
           return Response.status(Status.NOT_FOUND).entity("Not Found - " +    ex.getMessage()).build();
    }
}