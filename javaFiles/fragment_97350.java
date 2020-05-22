@Configuration
@EnableScheduling
public class AppConfig {
    @Bean
    public MyStatsLogger myStatsLogger() {
        return new MyStatsLogger();
    }
}