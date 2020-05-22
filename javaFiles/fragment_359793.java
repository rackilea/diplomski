@Configuration
public class AppConfig {

    // Beans present here will be injected into the SatzRechnerTest class.

    @Bean
    public SatzRechner satzRechner() {
        return new SatzRechner();
    }

    @Bean
    public Rechner taschenRechner() {
        return new TaschenRechner();
    }

    @Bean
    public Zahlenfabrik zahlenfabrik() {
        return new Zahlenfabrik();
    }
}