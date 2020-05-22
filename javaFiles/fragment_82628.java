@Bean
public static PropertySourcesPlaceholderConfigurer properties(){
  final PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
  // add your property files below
  final Resource[] resources = new ClassPathResource[]{new ClassPathResource("foo.properties")};
  pspc.setLocations( resources );
  // this will make the replacement fail, if property is not known
  pspc.setIgnoreUnresolvablePlaceholders(false); 
  return pspc;
}