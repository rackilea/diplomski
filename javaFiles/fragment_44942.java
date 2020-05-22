@Path("/test")
public class TestService {
    @Context
    private HttpHeaders headers;

    @GET
    @Path("/{pathParameter}")
    public Response testMethod() {
        (...)
        List<String> customHeaderValues = headers.getRequestHeader("X-MyCustomHeader");
        System.out.println(">> X-MyCustomHeader = " + customHeaderValues);
        (...)

        String response = (...)
        return Response.status(200).entity(response).build();
    }
}