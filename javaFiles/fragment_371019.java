@Configuration
public class TestConfiguration {
    @Bean
    public Engine getEngine() {
        Engine eng = new Engine();
        eng.setMsg("Message is being called");
        return eng;
    }
}