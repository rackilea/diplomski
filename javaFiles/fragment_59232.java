public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        ...
        bind(BaseClass.class)
        .annotatedWith(Names.named("firstBaseObject"))
        .toInstance(factoryClass.create("some_parameter"));

        bind(BaseClass.class)
        .annotatedWith(Names.named("secondBaseObject"))
        .toInstance(factoryClass.create("another_parameter"));
    }
}

public class AnotherClass {
    @Inject
    @Named("firstBaseObject")
    private BaseClass firstBaseObject;
    @Inject
    @Named("secondBaseObject")
    private BaseClass secondBaseObject;

    public void processSomething() {
        // ... do something that requires both firstBaseObject and secondBaseObject to already be initialized on each call
    }
}