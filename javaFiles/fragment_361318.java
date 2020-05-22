@POST
@Path("/add")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public Response addAlert(
        @FormParam("name") String name,
        @FormParam("amount") int amount, 
        @FormParam("timespan") String timespan, 
        @FormParam("repo") String repo, 
        @FormParam("action") String action) {
}