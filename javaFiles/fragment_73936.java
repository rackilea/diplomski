@Configuration
public class MongoConfig {

    @Bean
    public LoggingEventListener<Object> listener(){
        return new LoggingEventListener();
    }
}