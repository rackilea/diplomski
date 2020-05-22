@Provider
public class SecurityCheckDynamicFeature implements DynamicFeature {
    @Override
    public void configure(ResourceInfo info, FeatureContext context) {
        Method method = info.getResourceMethod();
        SecurityCheck annotation = method.getAnnotation(SecurityCheck.class);
        if (annotation != null) {
            context.register(SecurityFilter.class);
        }
    }
}