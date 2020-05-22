@Path("/v1/resource")
public class Resource {

    @GET
    public Response getResource() {
        return Response.ok("Hello Redirects!").build();
    }

    @POST
    @Path("/field")
    public Response getResource(@Context UriInfo uriInfo) {
        UriBuilder uriBuilder = uriInfo.getBaseUriBuilder();
        uriBuilder.path(Resource.class); 
        URI resourceBaseUri = uriBuilder.build();
        return Response.seeOther(resourceBaseUri).build();
    }
}