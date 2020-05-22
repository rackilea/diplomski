@Provider
public class UnrecognizedPropertyExceptionMapper implements ExceptionMapper<UnrecognizedPropertyException> {

   @Override
   public Response toResponse(UnrecognizedPropertyException e) {
      ExceptionDTO myDTO = // build response
      return Response.status(BAD_REQUEST).entity(myDTO).build();
   }
}