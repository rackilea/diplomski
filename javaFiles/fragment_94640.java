@Configuration
public class AppConfig {

    @Bean
    public MyService getMyService() {
        if(windows) return new MyServiceWin();
        else return new MyServiceLnx();
    }
}