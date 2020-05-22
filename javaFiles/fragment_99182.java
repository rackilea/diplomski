@SpringBootApplication
@PropertySource(name = "general-properties", value = { "classpath:path to your app.properties"})
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(NayapayApplication.class, args);
    }
}