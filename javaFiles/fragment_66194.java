@POST
@Path("/create")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)
public Response createFromPost(
        @FormParam("meg") String meg,
        @FormParam("name") String name) {
    ...
    return Response.created(theNewUrl).entity(theString).build();
}