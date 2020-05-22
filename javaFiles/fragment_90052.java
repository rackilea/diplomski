@Bean
public Configuration getConfiguration() {
   Configuration config = new Configuration();
   config
       .driverConfiguration()
       .setURI("bolt://localhost");
   return config;
}