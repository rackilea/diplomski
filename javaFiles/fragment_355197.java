import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/config.properties")
public class AppConfigMongoDB {

  @Value("${mongodb.url}")
  private String mongodbUrl;

  @Value("${mongodb.db}")
  private String defaultDb;

  public String getMongoDb() {
    return defaultDb;
  }

  public String getMongoDbUrl() {
    return mongodbUrl;
  }
}