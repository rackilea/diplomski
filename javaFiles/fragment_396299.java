@GET
@Produces(MediaType.TEXT_PLAIN)
public Response getToken() {
    String apiToken = ...
    return Response.ok(apiToken).build();  
}