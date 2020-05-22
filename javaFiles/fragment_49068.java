@Configuration
@Profile("prod")
public class ProdConfiguration  {

    @Bean
    public Database database() {
        return new ProdDb();
    }
}