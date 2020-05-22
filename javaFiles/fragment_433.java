@SpringBootApplication
@EnableZipkinStreamServe
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }
}