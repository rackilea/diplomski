@Component
public class ApplicationStartedListener implements ApplicationListener<ContextRefreshedEvent> {

    private static @Value("${my.user}") String username;
    private static @Value("${my.password}") String password;
    private static @Value("${my.connection}") String connectionString;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.setProperty("username",username);
        System.setProperty("password",password);
        System.setProperty("connectionString",connectionString);
    } 
}