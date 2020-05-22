@Provider
public class JAXBExceptionMapper implements ExceptionMapper<JAXBException> {

    public Response toResponse(JAXBException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity(e.getMessage());
                       .type("text/plain").build();
    }

}