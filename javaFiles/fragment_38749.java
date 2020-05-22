@ApplicationPath("/myApp")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("com.app.rest");
    }
}