@Path("/WS")
@WebService
public class WebService implements IWebService {

@Override
@POST
@Consumes("application/json")
@Produces("application/json")
@Path("/Login")
public Response Login(JSONObject data) {
    //stuff here
}
}