@SpringBootApplication
public class Kgh710Application {

    public static void main(String[] args) throws Exception {
        FileCopyUtils.copy(new ClassPathResource("client.ks").getInputStream(),
                new FileOutputStream("/tmp/client.ks"));

        SpringApplication.run(Kgh710Application.class, args);
    }

}