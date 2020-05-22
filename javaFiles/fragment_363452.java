@Provider
public class ExceptionMapperFactoryFeature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        final ServiceLocator locator = ServiceLocatorProvider.getServiceLocator(context);
        final Descriptor<?> descriptor = locator.getBestDescriptor(new Filter() {
            @Override
            public boolean matches(Descriptor d) {
                return d.getImplementation().equals(ExceptionMapperFactory.class.getName());
            } 
        });
        ServiceLocatorUtilities.removeOneDescriptor(locator, descriptor);

        context.register(new AbstractBinder() {
            @Override
            public void configure() {
                bindAsContract(MyExceptionMapperFactory.class)
                        .to(ExceptionMappers.class)
                        .in(Singleton.class);
            }
        });
        return true;
    }
}