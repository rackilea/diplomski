public class JettyRunner extends BlockJUnit4ClassRunner {
    private static boolean initialized = false;

    public JettyRunner(Class<?> klass) throws InitializationError {
        super(klass);

        synchronized (JettyRunner.class) {
            if (!initialized) {
                System.out.println("Let's run jetty...");
                initialized = true;
            }
        }
    }
}