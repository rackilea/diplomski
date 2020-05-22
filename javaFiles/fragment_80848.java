@Configuration
class Security extends ResourceServerConfigurerAdapter {

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("my-resource-name");
  }
}