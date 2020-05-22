public class NotFoundLoggingFilter implements ContainerResponseFilter {
    private ExampleLogger logger = new ExampleLogger();

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) {
        if (responseContext.getStatus() != 404) {
            return;
        }

        final URI absolutePath = requestContext.getUriInfo().getAbsolutePath();
        logger.error("filter: " + absolutePath, new NotFoundException());
    }
}