@Scope(value = "singleton")
@ConfigurationProperties("com.custom")
@Configuration
@EnableConfigurationProperties
@Data
public class AppProperties {

private String userName;
private String password;
}