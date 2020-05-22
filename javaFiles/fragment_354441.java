public class ApplicationConfig  extends ResourceConfig {
    public ApplicationConfig() {
        register(new ApplicationBinder());
        packages(true, "api");
    }
}