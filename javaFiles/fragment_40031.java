public class ApplicationResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(final ContainerRequestContext request,
        final ContainerResponseContext response) throws IOException {

        // your code
        response.getEntity();

    }
}