@Singleton
@Path("/service")
@Produces({MediaType.TEXT_PLAIN})
public class Service {

  @GET
  public String run() {
    return "Service running";
  }

}