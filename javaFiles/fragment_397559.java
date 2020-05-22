@Provider
public class GlobalExceptionHandler implements ExceptionMapper<JsonMappingException > {
    @Override
    public Response toResponse(JsonMappingException exception) {
        return Response.status(Status.INTERNAL_SERVER_ERROR)
            .entity("An error deserializing the JSON")
            .type(MediaType.TEXT_PLAIN)
            .build();
    }
}