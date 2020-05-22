@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException {
        resourceInfo.getResourceMethod().getAnnotation(ReadPermission.class);
    }
}