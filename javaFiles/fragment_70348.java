import jax.ws.rs.core.Context;

@Path("/server")
public class WebServer {
    @Context 
    private ServletContext context; 

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    // ...
}