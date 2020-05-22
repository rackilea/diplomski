@Path("/user")
public class TestResource {

    static{ DriverManager.registerDriver(new org.h2.Driver()) } 

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createForm(@FormParam("name") String name) throws Exception{

        Connection connection = DriverManager.getConnection("jdbc:h2:testDbName");
        connection.close();

        return Response.status(SC_ACCEPTED).build();
    }
}