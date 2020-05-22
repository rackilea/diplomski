@GET
@Path("{id}")
@Produces(/* ? */)
public Response get(String documentId) {
    Binary binary = ... // get binary from database
    return Response.ok(binary).build();
}