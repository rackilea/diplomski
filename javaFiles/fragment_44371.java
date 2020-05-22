@EnableJpaRepositories(basePackages = {"com.internal.signing.model"})
@EntityScan(value = {"com.internal.signing.model"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("In application");
    }
}