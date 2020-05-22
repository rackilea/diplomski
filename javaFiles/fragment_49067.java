@Configuration
@Profile("test")
public class TestConfiguration  {

    @Bean
    public Database database() {
        return new TestDb();
    }
}