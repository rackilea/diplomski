public class BaseResource
{

  @GET
  @Path("/url")
  public Response getCallbackUrl() {
    // Default code goes here
  }
}

@Path("/will")
public class WillResource extends BaseResource
{
  // Overrides go here
}

@Path("/abc")
public class AbcResource extends BaseResource
{
  // Overrides go here
}