@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // parse args here
        String host = getHost();
        int port = getPort();

        SpringApplication application = new SpringApplication(Application.class);

        // provide c'tor arguments and let Spring create the instance
        BeanDefinitionCustomizer bdc = bd -> {
            // working with bd.getPropertyValues() uses setter instead of c'tor
            ConstructorArgumentValues values = bd.getConstructorArgumentValues();
            values.addIndexedArgumentValue(0, host);
            values.addIndexedArgumentValue(1, port);
        };
        application.addInitializers((GenericApplicationContext ctx) -> ctx.registerBean(Requester.class, bdc));

        // or create the instance yourself
        Requester requester = new Requester(host, port);
        application.addInitializers((GenericApplicationContext ctx) -> ctx.registerBean(Requester.class, () -> requester));
        application.run(args);
    }

}