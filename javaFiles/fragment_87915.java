@Path("/")
public class MyService {
    @Context org.jboss.resteasy.spi.HttpResponse response;

    @GET @Path("/") public void setHeader(){
        response.getOutputHeaders().putSingle("X-Some-Header", "value");
    }
}