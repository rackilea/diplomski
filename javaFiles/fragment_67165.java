public class DemoApplicationContextInitializer implements
        ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext ac) {
        Application.context = ac;
    }
}


@SpringBootApplication
public class Application {

    public static ApplicationContext context;

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(Application.class)
        .initializers(new DemoApplicationContextInitializer())
        .run(args);
    }
}