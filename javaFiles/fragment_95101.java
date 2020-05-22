@GET
@Path("/get/{name}")
@Produces("image/png")
public Response getFile(@Context ServletContext context, @PathParam("name") String name) {

    String fullPath = context.getRealPath("/WEB-INF/images/" + name);
    File file = new File(fullPath);

    ResponseBuilder response = Response.ok((Object) file);
    response.header("Content-Disposition", "attachment; filename=" + name);
    return response.build();

}