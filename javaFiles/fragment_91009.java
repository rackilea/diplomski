import org.glassfish.jersey.server.ResourceConfig;

public class MiApp extends ResourceConfig{
    public MiApp() {
        packages("com");
    }
}