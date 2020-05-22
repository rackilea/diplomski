@SpringBootApplication(exclude=MongoAutoConfiguration.class)
public class YourMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}