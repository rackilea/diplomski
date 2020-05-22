@SpringBootApplication
@EnableGemFireHttpSession
class MySpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

    ...
}