public class MySingleton 
    implements IConfigurationObserver {
    // Member(s)
    private static volatile MySingleton instance;
    private final Configuration configuration;
    private volatile ParsedConfiguration currentConfig;

    // Constructor(s)
    private MySingleton(Configuration configuration) {
        this.configuration = configuration;
        parseConfiguration();
        configuration.addObserver(this);
    }

    public static MySingleton getInstance(Configuration configuration) {
        // Perform synchronized creation if applicable (double locking technique)
        MySingleton syncInstance = instance;
        if (syncInstance == null) {
            synchronized(MySingleton.class) {
                syncInstance = instance; // Verify once again after synchronizing
                if(syncInstance == null) {  
                    syncInstance = new MySingleton(configuration);
                    instance = syncInstance;
                }
            }
        }

        return syncInstance;
    }

    // Private Method(s)
    private void parseConfiguration() {
        // Import values from the configuration
        currentConfig = configuration.getNewParsedConfiguration();
    }

    // Public Method(s)
    public String buildSentence() {
        // Build a new string based on values pulled from the current configuration
        ParsedConfiguration configInUse = currentConfig;
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(configInUse.getFirstParam());
        strBuilder.append(" - ");
        strBuilder.append(configInUse.getSecondParam());

        return strBuilder.toString();
    }

    // Observer Method(s)
    @Override
    public void onConfigurationUpdated() {
        // The configuration has changed. Parse it again.
        parseConfiguration();
    }
}