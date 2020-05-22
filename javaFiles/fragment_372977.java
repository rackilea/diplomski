@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean
    public Search search(){
        return new Search();
    }
}