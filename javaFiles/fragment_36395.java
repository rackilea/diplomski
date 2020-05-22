@GET
@Path("/{id}")
@Produces("text/plain")
public String demonstration(@PathParam("id") String id,
        @Context UriInfo ui, @Context Authentication auth) {
    // ...