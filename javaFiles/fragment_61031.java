public class RequestIdContainerFilter implements ContainerRequestFilter {

@Override
public void filter(ContainerRequestContext containerRequestContext) throws IOException {
    containerRequestContext.setProperty("property-name", "any-object-you-like");
}