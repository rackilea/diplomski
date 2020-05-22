@SpringBootApplication
public class Application implements CommandLineRunner{

  @Override
  public void run(String... strings) {
      //here your code...
  }

  public static void main(String[] args) throws Exception {
      SpringApplication.run(Application.class, args);    
  }
}