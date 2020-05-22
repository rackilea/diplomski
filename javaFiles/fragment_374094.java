import javax.ws.rs.GET;
@Path("/restcall2")
public class restcall2 {      
  @POST
  @Produces("text/plain")
  public Response RESTcall(String f) throws JSONException {
      System.out.println(f);
    return Response.status(200).entity("hello " + f).build();
  }