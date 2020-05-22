public class ClassThatIsUsingTheConfig {
    private final String endpoint;
    public ClassThatIsUsingTheConfig(final String endpoint) {
        this.endpoint = endpoint;
    }

    public void someMethod() {
        // use endpoint
    }
}