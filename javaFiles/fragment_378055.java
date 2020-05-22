@Provider
public class ResourceFilteringConfiguration implements DynamicFeature {

    @Inject
    private RegisterServiceInterceptor registerServiceInterceptor;

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        if (RegistrationService.class.equals(resourceInfo.getResourceClass())
                && resourceInfo.getResourceMethod().getName().equals("register")) {
            context.register(registerServiceInterceptor);
        }
    }

}