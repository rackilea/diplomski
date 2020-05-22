@Provider
public class ResourceFilteringConfiguration implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        if (RegistrationService.class.equals(resourceInfo.getResourceClass())
                && resourceInfo.getResourceMethod().getName().equals("register")) {
            context.register(RegisterServiceInterceptor.class);
        }
    }

}