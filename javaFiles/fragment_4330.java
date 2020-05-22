@Configuration
public class AmazonServiceConfiguration {
  @Bean
  public AmazonEC2 ec2() {
    return AmazonEC2ClientBuilder.standard()
      .withRegion(Regions.AP_SOUTH_1).build();
  }   
}