@Configuration
public class Config {

    @Bean
    public Bean1 bean1() {
        return new Bean1();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
    }
}