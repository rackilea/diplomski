@GET
@Path("/foo")
@Produces(MediaType.APPLICATION_XML)
public Response foo(@BeanParam MyBean myBean) {
    return Response.ok(myBean).build();
}