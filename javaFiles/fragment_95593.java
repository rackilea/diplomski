@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException exception) {
        Map<String, String> map = new HashMap<>();
        map.put("exception", exception.getClass().getName());
        map.put("message", exception.getMessage());
        return Response.status(500).entity(map).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

}