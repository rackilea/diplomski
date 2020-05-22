public class CustomSpringApplicationContextLoader extends SpringApplicationContextLoader {

    @Override
    protected SpringApplication getSpringApplication() {
        return new SpringApplicationBuilder().headless(false).build();
    }

}