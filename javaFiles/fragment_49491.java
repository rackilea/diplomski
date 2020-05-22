public class SpringProfilesFeature implements Feature {

    @Inject
    private ApplicationContext context;

    @Override
    public boolean configure(FeatureContext featureContext) {
        Map<String, Object> resources = context.getBeansWithAnnotation(Path.class);

        resources.values().forEach(resource -> featureContext.register(resource));

        return true;
    }
}