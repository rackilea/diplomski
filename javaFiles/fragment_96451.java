@provider
 public class UnmarshalExceptionMapper 
            implements ExceptionMapper<UnmarshalException> {
    public Response toResponse(UnmarshalException exception) {
        ResponseBuilder rb =
            Response.status(
                  Response.Status.BAD_REQUEST)  // Most appropriate HTTP status code
            .entity(your xml goes here)
            .type("application/xml");  
        return rb.build();
   }
 }