public class InjectionFeature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {

        context.register(new AbstractBinder(){
            @Override
            protected void configure() {
                bind(SampleProducer.class)
                        .to(SampleProducer.class).in(Singleton.class);
            }
        });
        return true;
    }
}