@Configuration
public class AppConfig {

    @Bean
    public MyService service() {
        return new MyServiceImpl();
    }

    @Bean
    @Scope("prototype")
    public SomeController someController() {
        return new SomeController();
    }

    // ...
}