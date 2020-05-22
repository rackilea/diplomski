@Path("/app")
public class YourHandler {

    @Produces(MediaType.APPLICATION_JSON)
    public String yourHandlerForApp() {
        // This method is be exposed at /app
    }

    @Path("/fizz") 
    @Produces(MediaType.APPLICATION_JSON)
    public String yourHandlerForAppSlashFizz() {
        // This method is be exposed at /app/fizz
    }
}