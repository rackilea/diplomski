public class MyWebTargetFactory implements Factory<WebTarget> {

    @Context
    private ContainerRequestContext containerRequestContext;

    @Inject
    public MyWebTargetFactory(ContainerRequestContext containerRequestContext) {
        this.containerRequestContext = containerRequestContext;
    }

    @Override
    public WebTarget provide() {
        Client client = ClientBuilder.newClient();
        client.register(new RequestIdClientRequestFilter(containerRequestContext));
        return client.target("path/to/api");
    }

    @Override
    public void dispose(WebTarget target) {

    }
}