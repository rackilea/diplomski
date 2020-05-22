@ApplicationPath("resources")
    public class JerseyApplication extends ResourceConfig {
    public JerseyRestApplication() {            
        packages("com.sample", "com.fasterxml.jackson.jaxrs.json");
    }
}