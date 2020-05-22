@SpringBootApplication
@EntityScan("my.application.core")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}