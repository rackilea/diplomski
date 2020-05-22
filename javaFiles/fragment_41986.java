Config conf = ConfigFactory.load();

// create a config containing only the system properties
Config emptyConfig = ConfigFactory.systemProperties();

// check that the loaded config is not equal to this "empty config"
Boolean isDefinedConfig = ! conf.equals(emptyConfig);