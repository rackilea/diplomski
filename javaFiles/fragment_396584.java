public class Endpoint implements PointInterface<Endpoint> {
    @Override
    public InHandlerInterface<Endpoint> getInHandler() {
        return new EndpointInHandler<>();
    }

    public String specificToEndpoint() {
        return "Whatever";
    }
}