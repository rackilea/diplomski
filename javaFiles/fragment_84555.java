@GET
@Path("/some-path")
public String read(@QueryParam("name") String name) {
  if (name == null) {
    throw new WebApplicationException(
      Response.status(Response.Status.BAD_REQUEST)
        .entity("name parameter is mandatory")
        .build()
    );
  }
  // continue with a normal flow
}