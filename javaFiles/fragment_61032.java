public class RequestIdClientRequestFilter implements ClientRequestFilter {

    private ContainerRequestContext containerRequestContext;

    public RequestIdClientRequestFilter(ContainerRequestContext containerRequestContext) {
        this.containerRequestContext = containerRequestContext;
    }

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        String value = containerRequestContext.getProperty("property-name");
        clientRequestContext.getHeaders().putSingle("MyHeader", value);
    }
}