public class SuperResource {
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getInfo() {
        return Response.ok("{\"info\":1}").build(); 
    }
}

@Path("test")
public class MyResource  extends SuperResource{
    // ... other endpoints
}