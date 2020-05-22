public class ForbiddenDispatcherFilter implements DispatcherFilter {
    AssistedInjectionFactory factory;

    @Inject
    public ForbiddenDispatcherFilter(AssistedInjectionFactory factory) 
    {
        this.factory = factory;
    }

    @Override
    public boolean filter(Method method, RequestBuilder builder) {
        builder.setCallback(factory.AssistedInjectionFactory(method)) 
        return true;
    }
}