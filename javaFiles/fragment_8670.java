@Configuration
public class AppConfiguration {

    @Bean
    // ??? surely a service should be singleton, not prototype, scope...
    @Scope("prototype")
    public MainService mainService() {
        return new InMemoryMainService();
    }

    @Bean
    @Scope("prototype")
    public MainController mainController() throws IOException {
        return new MainController();
    }

    @Bean
    @Scope("prototype")
    public MenuController menuController() throws IOException {
        return new MenuController();
    }


}