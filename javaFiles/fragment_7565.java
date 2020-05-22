@POST
@Path("/postPlayer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response createJsonPlayer(WeekendPlayer player) {
    return Response.ok("It works!");
}