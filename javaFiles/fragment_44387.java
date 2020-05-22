@SpringBootApplication
@EnableJpaRepositories
public class HelloWorldSpringBootApp {


    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(HelloWorldSpringBootApp.class, args);
        Running r1 = applicationContext.getBean(Running.class);
        r1.run();
    }
}