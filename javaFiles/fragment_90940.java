@GET
@Path("/{username}")
@Produces({ "application/xml", "application/json" })
public Response getUserByName( @PathParam("username") String username,@Context SecurityContext securityContext)
throws NotFoundException {
    return delegate.getUserByName(username,securityContext);
}