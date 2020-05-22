@Provider
public class ValidationExceptionMapper implements ExceptionMapper<javax.validation.ConstraintViolationException> {

    public Response toResponse(javax.validation.ConstraintViolationException cex) {
       Error error = new Error();
       error.setMessage("Whatever message you want to send to user. " + cex);
       return Response.entity(error).status(400).build(); //400 - bad request seems to be good choice
    }
}