public class EndpointInHandler implements InHandlerInterface<Endpoint> {
    @Override
    public void handle(Path<Endpoint, ?> path) {
        Endpoint in = path.getIn(); // This is naturally type safe, and compiler won't complain

        String whatever = in.specificToEndpoint();
    }
}