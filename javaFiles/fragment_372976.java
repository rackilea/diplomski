@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
     public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AppConfig.class, args);
        ctx.getBean...
    }
}