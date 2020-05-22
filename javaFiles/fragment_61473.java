public class MyFeature implements Feature {

    @Override
    public boolean configure(final FeatureContext context) {
        context.register(new MyResolverBinder());
        return true;
    }
}