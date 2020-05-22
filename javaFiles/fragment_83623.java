@GET
@Path("/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Response getModel(@PathParam("id") Long id) throws Exception {
    ...
}