@Path(value = "/job")
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response insertJob(
        Job test
) {
    return Response.ok(test).build();

}