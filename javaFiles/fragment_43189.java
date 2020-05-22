@Configuration
public class Configuration {



    @Bean
    public MyBean myBeanFirst() {
        return new MyBean();
    }

    @Bean
    public MyBean myBeanSecond() {
        return new MyBean();
    }

}