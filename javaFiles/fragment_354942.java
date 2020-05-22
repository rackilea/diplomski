@Provider
public class ExampleExceptionMapper implements ExceptionMapper<ExampleException>  {
    @Context Request request;         
    @Override
    public Response toResponse(ExampleException ex) {
        if ("POST".equals(requset.getMethod()))
           return Response.status(Status.BAD_REQUEST).build();
        else
           return Response.status(Status.NOT_FOUND).entity("Not Found - " +    ex.getMessage()).build();
    }
}