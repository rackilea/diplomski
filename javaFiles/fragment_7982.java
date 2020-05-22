@ApplicationPath("api")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("package.to.scan");
    }
}