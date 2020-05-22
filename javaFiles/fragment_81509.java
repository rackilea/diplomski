@GET
@Path("/authenticateUserAndGetHospitalDetails") 
@Produces(MediaType.APPLICATION_JSON)
public Hospital getAllHospitalData(@PathParam("userId") String userId, @QueryParam("password") String password, @QueryParam("username") String username) {

...