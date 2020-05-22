public class NotFoundLogger implements ExceptionMapper<NotFoundException> {

    // magically inject a thing
    // remember that magic is for evil wizards
    @Context
    private HttpServletRequest request;

    private ExampleLogger logger = new ExampleLogger();

    @Override
    public Response toResponse(final NotFoundException exception) {
        final StringBuffer absolutePath = HttpUtils.getRequestURL(request);
        logger.error("exception mapper: " + absolutePath, exception);
        return Response.status(404).build();
    }
}