@POST
@Path("/postPlayer")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public Response createJsonPlayer(WeekendPlayer player) {
    return Response.ok();
}