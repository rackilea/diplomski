@PUT
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/{id}")
public Response update(final Role r, @PathParam("id") Long id) {
    // do some processing... save to the db
}