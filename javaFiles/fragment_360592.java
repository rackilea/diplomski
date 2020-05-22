@Provider
public class CustomFilterBadRequest implements ExceptionMapper<CustomBadRequest> {

  @Override
  public Response toResponse(CustomBadRequest exception) {
    return Response.status(400).entity(new ErrorDetails(new Date(),
      400, "bad request", exception.getMessage(),exception.getUriInfo())).type(MediaType.APPLICATION_JSON).build();
  }
}