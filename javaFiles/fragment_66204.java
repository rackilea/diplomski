@SpringBootApplication
@EnableCaching
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}

@Configuration
@EnableEurekaClient
@Profile("eureka-client")
public class EurekaClientConfiguration {
}