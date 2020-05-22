public class SimpleClass {
    public void doSomething() {
        System.out.println("Consider it done");
    }

   @PostConstruct
    public void initialize() {
        System.out.println("Starting");
    }

    @PreDestroy
    public void stop() {
        System.out.println("Stopping");
    }
}

public class Test {

    @Inject
    private SimpleClass simple;

    public void main(@Observes ContainerInitialized event) {
        System.out.println("Starting application");
        simple.doSomething();
    }       
}