package anyq.server.anyq.manager;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import anyq.server.common.bean.User;

@Path("/users")
public class AnyQUserManager {

@Context
UriInfo uriInfo;

@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response createUser(User user) {
    System.out.println("HELLO WORLD");
    return Response.status(666).entity("Hello world").build();
}
}