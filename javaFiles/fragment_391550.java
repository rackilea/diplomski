public class PropertyContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {


       @Override
       public void initialize( ConfigurableApplicationContext applicationContext ) {
          ConfigurableEnvironment environment = applicationContext.getEnvironment();
          for ( PropertySource<?> propertySource : environment.getPropertySources() ) {
             Map<String, Object> propertyOverrides = new LinkedHashMap<>();
// call to decrypt method
             decryptProperty( propertySource, propertyOverrides );
             if ( !propertyOverrides.isEmpty() ) {
                PropertySource<?> decodedProperties = new MapPropertySource( "decrypt " + propertySource.getName(),
                      propertyOverrides );
                environment.getPropertySources().addBefore( propertySource.getName(), decodedProperties );
             }
          }
       }