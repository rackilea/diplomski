@WebEndpointExtension(endpoint = MyHealthEndpoint.class)
public class MyHealthWebEndpointExtension {

    private final MyHealthEndpoint delegate;

    public MyHealthWebEndpointExtension(MyHealthEndpoint delegate) {
        this.delegate = delegate;
    }

    @ReadOperation
    public WebEndpointResponse<MyHealth> getHealth() {
        MyHealth health = delegate.health();
        return new WebEndpointResponse<>(health, 200);
    }
}