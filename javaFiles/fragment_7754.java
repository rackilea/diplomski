public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("packages.to.scan");
        register(JacksonFeature.class);
    }
}