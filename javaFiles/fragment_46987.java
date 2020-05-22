@Configuration
public class ConfigurationClass {

    @Resource(name="urlsRequireAuthentication")
    private List<String> urlsRequireAuthentication;

    @Bean
    public FilterRegistrationBean someFilterRegistrationBean() {
        urlsRequireAuthentication.size();
    }
}