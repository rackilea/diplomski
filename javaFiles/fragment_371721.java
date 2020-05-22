@GET
@Path("/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Response myResourceMethod(@PathParam("id") Long id, 
                                 @Context SecurityContext securityContext) {
    ...
}