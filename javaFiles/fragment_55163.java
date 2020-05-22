@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("the.packages.to.scan");

        register(RestService.class);
    }
}