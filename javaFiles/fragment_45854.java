public Bootstrap(Application<T> application) {
    this.application = application;
    this.objectMapper = Jackson.newObjectMapper();
    this.bundles = new ArrayList<>();
    this.configuredBundles = new ArrayList<>();
    this.commands = new ArrayList<>();
    this.validatorFactory = Validators.newValidatorFactory();
    this.metricRegistry = new MetricRegistry();
    this.configurationSourceProvider = new FileConfigurationSourceProvider();
    this.classLoader = Thread.currentThread().getContextClassLoader();
    this.configurationFactoryFactory = new DefaultConfigurationFactoryFactory<>();
    this.healthCheckRegistry = new HealthCheckRegistry();
}