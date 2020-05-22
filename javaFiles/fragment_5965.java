@Path("/hello/world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    @POST
    @Path("/v1")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(@Valid @Validated(V1Check.class) User user) {
        // checks only username
        System.out.println(user.getName());
        System.out.println(user.getPassword());

        return Response.ok().build();
    }


    @POST
    @Path("/v2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response test2(@Valid @Validated(V2Check.class) User user) {
        // checks both
        System.out.println(user.getName());
        System.out.println(user.getPassword());

        return Response.ok().build();
    }
}