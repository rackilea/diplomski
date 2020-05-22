@Provider
public class GreetingFeature implements Feature {
    @Override
    public boolean configure(FeatureContext context) {
        context.register(new AbstractBinder(){
            @Override
            public void configure() {
                bind(EnglishGreeter.class).named("english")
                        .to(Greeter.class).in(Singleton.class);
                bind(SpanishGreeter.class).named("spanish")
                        .to(Greeter.class).in(Singleton.class);
            }
        });
        return true;
    }  
}