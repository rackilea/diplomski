CompositeConfiguration configuration = new CompositeConfiguration();
try {
  configuration.addConfiguration(new SystemConfiguration());
  configuration.addConfiguration(new PropertiesConfiguration("app.properties"));
} catch (ConfigurationException e) {
  e.printStackTrace();
}
//Read your configuration values here