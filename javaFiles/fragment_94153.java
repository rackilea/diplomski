@SpringBootApplication
public class Application {

private static final Logger log = LoggerFactory.getLogger(Application.class);

public static void main(String args[]) {
    SpringApplication.run(Application.class);
}

@Bean
public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
}

@Bean
public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
    return args -> {
        Quote quote = restTemplate.getForObject(
                "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
    };
}
}