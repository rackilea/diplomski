@Configuration
@ImportResource("classpath:pl/rav/springtest/resources/app.xml")
public class AppConfig {
    @Bean(name="myMessageService")
    MessageService mockMessageService() {
        return new MessageServiceImpl();
    }
}