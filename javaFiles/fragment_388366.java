@ApplicationScoped
public class App {

    @Inject
    @Parameters
    List<String> parameters;

    @Inject
    @Named("string.value")
    String stringValue;

    public void printHello(@Observes ContainerInitialized event) {
        System.out.println("String Value is " + stringValue);
    }

}