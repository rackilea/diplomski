@SpringBootApplication
public class MyApplication {

    @Bean
    public MeterBinder exampleMeterBinder() {
        return (meterRegistry) -> Counter.builder("myCounter")
            .description("indicates instance count of the object")
            .tags("dev", "performance")
            .register(meterRegistry);
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication, args);
    }

}