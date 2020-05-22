@Provider
@Path("/")
public class xxx
{

  @GET
  @Path(value = "path1")
  public Response m1(@QueryParam(value = "a") String a)
  {
    ...
  }



  @GET
  @Path(value = "path2")
  public Response m2(@QueryParam(value = "b") String b)
  {
    ...
  }

}