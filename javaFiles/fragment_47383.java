@GET
@Path("/{id}")
@Produces({ "application/json" })
public Response createMyEndpoint(@PathParam("id") String id) {
    try {
        return Response.ok().entity(myEndpointDao.read(id)).build();
    } catch (Exception e) {
       Response.status(500).entity(e.getMessage()).build();
    }
}