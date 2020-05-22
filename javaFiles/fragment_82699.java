@Provider
public class ClientExceptionMapper implements ExceptionMapper<Throwable>
{
    @Override
    public Response toResponse(Throwable ex) 
    {

        return Response
                .status(Response.Status.BAD_REQUEST)
                .build();
    }
}