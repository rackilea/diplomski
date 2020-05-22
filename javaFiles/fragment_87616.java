@GET
@Path("get")
public Response getInTestResource()
{
    return Response.status(Status.OK).type(MediaType.APPLICATION_JSON).entity("get is ok").build();
}