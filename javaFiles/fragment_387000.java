@Path("persons")
public class PersonResource {

    @Path("/{id}")
    public Response get(@PathParam("id") String id) {
      //
    }

}