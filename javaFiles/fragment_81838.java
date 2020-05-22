// can put this been in any related config class, no need to create new one
@Configuration
public class Config { 
    @Bean 
    public WebSSOProfileConsumer getWebSSOProfileConsumerImpl(){
        WebSSOProfileConsumerImpl consumer = new WebSSOProfileConsumerImpl();
        consumer.setMaxAuthenticationAge(5000);
        return consumer;
    }
}