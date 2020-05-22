@Provider
public class BasicAuthInjectionProvider
        implements InjectableProvider<BasicAuth, Parameter> {

    @Override
    public ComponentScope getScope() {
        return ComponentScope.PerRequest;
    }

    @Override
    public Injectable getInjectable(ComponentContext cc, BasicAuth a, Parameter c) {
        return new BasicAuthInjectable();
    }
}