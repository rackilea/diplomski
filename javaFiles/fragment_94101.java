public interface GenService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/agentLogin/{ext}")

    public String agentLogin(@PathParam("ext") Integer ext);

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/agentLogout")
    public String agentLogout(String ext);

}