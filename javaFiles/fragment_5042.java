@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        final AppBean app = context.getBean(AppBean.class);
        app.run(args);
    }
}