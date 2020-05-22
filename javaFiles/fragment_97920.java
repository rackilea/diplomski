@Path("/testify")
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response Testify(@Context HttpServletResponse response, 
                        @Context HttpServletRequest request) throws Exception {
    try {
        return Utilities.getSvc(true, "OK");

    } catch (Exception e) {
        return Utilities.getSvc(false, "ERROR");
    }
}