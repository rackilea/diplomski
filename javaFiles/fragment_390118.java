public interface WebApi
{
  @GET
  @Path("/{id}/")
  String getStuff(@PathParam("id") String id);
}


@Path("/web")
public class WebApiServer implements WebApi
{
  private final Logger logger = LoggerFactory.getLogger(getClass());

  public String getStuff(String id)
  {
    logger.info("get called with args {}", id);
    return "asdf";
  }
}