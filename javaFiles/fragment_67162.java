public class ProductionModule extends AbstractModule {
    protected void configure() {
        // snip
    }

    @Provides @Singleton
    protected MyObject provideMyObject(Dependency dependency) {
        return delegateProvide(dependency);
    }

    // note the lack of annotations
    protected MyObject delegateProvide(Dependency dependency) {
        return new MyObject(dependency);
    }
}