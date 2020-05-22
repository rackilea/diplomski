@Configuration
public class AppConfig {

    @Bean
    public FichierCommunRetriever fichierCommunRetriever() {
        return new FichierCommunRetriever();
    }

}