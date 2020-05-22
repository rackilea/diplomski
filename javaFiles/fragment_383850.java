import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/people")
public class PersonService {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/person/{id}/")
  @ApiOperation(
      value = "api value",
      notes = "api notes "
  )
  public Response getPerson(@PathParam("id") String personId) throws Exception {
      PersonResponse p = new PersonResponse();
      return Response.ok(p).build();
  }
}