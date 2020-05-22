import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

public class Hello implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        requestContext.getMethod();
        requestContext.getUriInfo().getPath();
        requestContext.getHeaderString("authorization");
    } 
}