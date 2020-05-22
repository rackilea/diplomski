@SpringBootApplication
public class MyApp {

    public static void main(String[] args) throws Exception {
        System.setProperty("user.timezone", "UTC");
        SpringApplication.run(MyApp.class, args);
    }

}