@GET
@Path("...")
@Produces({MediaType.APPLICATION_JSON})
public String getPath(
    @PathParam("...") String path, 
    @Context HttpHeaders headers) {
...