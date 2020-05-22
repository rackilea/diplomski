@POST
@Path("/{path:.*}/")
@Encoded
@Consumes({"application/x-www-form-urlencoded"})
@Produces({"application/json"})
public Response alterDocument(final @Context UriInfo ui, 
  final @Context HttpHeaders hh,
  final @PathParam("session") String sessionToken,
  final @PathParam("path") String path,
  @FormParam("name") String name) throws WebApplicationException {
    /// code here not reached on call described below ....
 }