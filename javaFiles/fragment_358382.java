@Path("/hello")
public class HelloWorld {

    @GET
    @Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("{name}")
    public Person showPerson(@PathParam("name") String name) {
        return new Person(name);
    }

}