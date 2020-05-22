@Provider
@Priority(Priorities.HEADER_DECORATOR)
public class MediaTypeFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        for (Annotation annotation : responseContext.getEntityAnnotations()) {
            filterProducesAnnotation(annotation, responseContext);
        }
    }

    private void filterProducesAnnotation(Annotation annotation, ContainerResponseContext responseContext) {
        if (annotation instanceof Produces) {
            Produces produces = (Produces) annotation;
            filterMediaTypes(produces, responseContext);
        }
    }

    private void filterMediaTypes(Produces produces, ContainerResponseContext responseContext) {
        List<Object> mediaTypes = new ArrayList<Object>();
        for (String mediaType : produces.value()) {
            contentTypes.add(mediaType.equals(MediaType.APPLICATION_JSON) ? mediaType + ";charset=UTF-8" : mediaType);
        }
        responseContext.getHeaders().put("Content-Type", mediaTypes);
    }
}