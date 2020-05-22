private void initializeConfiguration() {

    // FixedDelayPollingScheduler is initialized with default system
    // settings
    // Fixed delay in milliseconds between two reads of the configuration
    // URLs
    // archaius.fixedDelayPollingScheduler.delayMills = 60000
    // Initial delay in milliseconds of reading from the configuration
    // source
    // archaius.fixedDelayPollingScheduler.initialDelayMills = 30000
    AbstractPollingScheduler scheduler = new FixedDelayPollingScheduler();

    // Configuration source that brings dynamic changes to the configuration
    // via polling
    PolledConfigurationSource source = new XMLPolledConfigurationSource();

    // Configuration that polls a PolledConfigurationSource according to the
    // schedule set by a scheduler
    DynamicConfiguration configuration = new DynamicConfiguration(source, scheduler);

    ConfigurationManager.install(configuration);

    // Registering configuration with an MBean and will be accessible for
    // read and update via JConsole
    ConfigJMXManager.registerConfigMbean(configuration);
}