@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
            .sources(SpringBootApp.class)
            .run(args);
    }
}