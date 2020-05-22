@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "datasource")
public class ApplicationConfig {

    private String serverUrl;
    private String adminName;
    private String adminPassword;
    private String baseDN;

    //getters setters

}