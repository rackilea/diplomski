@ApplicationPath("resources")
public class JerseyRestApplication extends ResourceConfig {
    public JerseyApplication() {
        register(JacksonJsonProvider.class); // Do it manually

        packages("com.sample");
    }
}