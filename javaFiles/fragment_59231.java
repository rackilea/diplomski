public class AnotherClass {
    private final BaseClass firstBaseObject;
    private final BaseClass secondBaseObject;

    @Inject
    public AnotherClass(FactoryClass factoryClass) {
       firstBaseObject = factoryClass.create("some_parameter");
       secondBaseObject = factoryClass.create("another_parameter");
    }

    public void processSomething() {
        // ... do something that requires both firstBaseObject and secondBaseObject to already be initialized on each call
    }
}