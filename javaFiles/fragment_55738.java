import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Client/{client}/users")
public interface UserPage {
   @GET
   @Produces(MediaType.TEXT_HTML)
   public String userChoice(@PathParam(value = "client") final String client);

   @GET
   @Path("/{name}")
   @Produces(MediaType.TEXT_HTML)
   public String userPage(@PathParam(value = "client") final String client,
         @PathParam(value = "name") final String name);
}