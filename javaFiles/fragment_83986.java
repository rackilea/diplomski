@Bean
 public static PropertySourcesPlaceholderConfigurer   propertySourcesPlaceholderConfigurer() {
     PropertySourcesPlaceholderConfigurer p =  new PropertySourcesPlaceholderConfigurer();
     p.setIgnoreResourceNotFound(true);

    return p;
 }