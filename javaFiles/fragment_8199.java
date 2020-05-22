@SpringBootApplication
@Import({InfraConfiguration.class}) // needs EntityManager
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}