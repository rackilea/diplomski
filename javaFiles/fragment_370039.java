import dropwizard.sample.helloworld.security.Roles;
import dropwizard.sample.helloworld.security.SimplePrincipal;
import io.dropwizard.auth.Auth;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/simple")
public class SimpleResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse(@Auth SimplePrincipal principal) {
        if (!principal.isUserInRole(Roles.ADMIN)) {
            throw new WebApplicationException(Response.Status.FORBIDDEN);
        }
        return Response.ok(
                "{\"Hello\": \"" + principal.getUsername() + "\"}").build();
    }
}