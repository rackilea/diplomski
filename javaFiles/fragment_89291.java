@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    // You can get the header from the `requestContext`
    @Override
    public void filter(ContainerRequestContext requestContext) {
        Method resourceMethod = resourceInfo.getResourceMethod();
        SecurityCheck annotation = resourceMethod.getAnnotation(SecurityCheck.class);
        // get some value from annotation

        if (notAllowedAccess) {
            throw new WebApplicationException(403);
        }
    }
}