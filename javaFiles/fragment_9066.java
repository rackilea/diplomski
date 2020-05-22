@Path("/{locale}/username")
public class UserResource {

   @GET
   @Produces("text/xml")
   public String getUser(@PathParam("locale") String locale) {
       ...
   }
}