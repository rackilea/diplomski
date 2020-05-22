@ConfigurationProperties(prefix = "prefix")
@PropertySource("path to properties file, you can inject it as property ${spring.config.location}")
@RefreshScope
public class ServiceOutputProperties {
  private int param;

//getters & setters
}