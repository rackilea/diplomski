@Bean
public static PropertySourcesPlaceholderConfigurer properties(){
  PropertySourcesPlaceholderConfigurer pspc =
   new PropertySourcesPlaceholderConfigurer();
  Resource[] resources = new ClassPathResource[ ]
   { new ClassPathResource( "foo.properties" ) };
  pspc.setLocations( resources );
  //pspc.setIgnoreUnresolvablePlaceholders( true );
  return pspc;
}