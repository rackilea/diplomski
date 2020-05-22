@SpringBootApplication
public class Client {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Client.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

    @Bean
    public CommandLineRunner myCommandLineRunner() {
      return args -> {
        // we have to block here, since command line runners don't
        // consume reactive types and simply return after the execution
        String result = WebClient.create("http://localhost:8080")
                .post()
                .uri("/fluxService")
                .body("Hallo")
                .accept(MediaType.TEXT_PLAIN)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        // print the result?
      };
    }
}