@Component
@ConfigurationProperties(prefix = "server")
public class ServerConfig {
  private String host;
  private String port;
  private String enableLog;
  // ... Getter/setter
}