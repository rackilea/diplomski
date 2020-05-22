public interface IWebService {

@POST
@Consumes("application/json")
@Produces("application/json")
@Path("/Login")
public Response Login(JSONObject data);

}