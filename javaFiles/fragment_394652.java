public class RoutingContextFactory implements
Supplier<RoutingContext> {

@Inject
private ContainerRequest request;

@Override
public RoutingContext get() {

    return (RoutingContext) request.getProperty(RoutingContext.class.getName());
}
}