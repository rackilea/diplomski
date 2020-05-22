public class GetConfigIntegrator implements Integrator {

    private static Configuration configuration;

    public static Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public void integrate(Configuration configuration, /* ... */) {
        GetConfigIntegrator.configuration = configuration;
    }

    // Empty Integrator implementation...
}