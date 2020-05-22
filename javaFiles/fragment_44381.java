public class MyContainerResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        // You can get the body of the response from the ContainerResponseContext
        Object entity = containerResponseContext.getEntity();
        // You'll need to know what kind of Object the entity is in order to do something useful though
        // You can get some data using these functions
        Class<?> entityClass = containerResponseContext.getEntityClass();
        Type entityType = containerResponseContext.getEntityType();

        // And/or by looking at the ContainerRequestContext and knowing what the response entity will be
        String method = containerRequestContext.getMethod();
        UriInfo uriInfo = containerRequestContext.getUriInfo();

        // Then you can modify your Authorization header in some way
        String authorizationHeaderValue = containerResponseContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        authorizationHeaderValue = authorizationHeaderValue + " a signature you calculated";
        containerResponseContext.getHeaders().putSingle(HttpHeaders.AUTHORIZATION, authorizationHeaderValue);
    }
}