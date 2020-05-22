@SpringBootApplication
public class Main  {

    @Bean
    public ImplementationResolver publisherImplementationResolver() {
        //If spring could figure out what class to use, It would be even better
        //but now I don't see any way to do that, and I manually create this
        //bean
        return new ImplementationResolver<Publisher>(Publisher.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }
}