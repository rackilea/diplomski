@Provider
public class GlobalExceptionHandlerController implements ExceptionMapper<ResourceNotFoundException> {
  @Override
  public Response toResponse(ResourceNotFoundException e) {
    ExceptionResponse response = new ExceptionResponse();
    response.setErrorCode("resource not found");
    response.setErrorMessage(e.getMessage());

    return Response.status(404).entity(response)
    .type("application/json").build();
  }
}