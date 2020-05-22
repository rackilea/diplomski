@Configration
public class MockConfig {

  @Bean
  @Primary
  public ExternalService externalService() {
    return mock(ExternalService.class);
  }
}