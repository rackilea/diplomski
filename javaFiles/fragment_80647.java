@Configuration
public class MyConfiguration {
    @Bean(name = "firstService")
    public MyService myService1() {
        return new MyService();
    }

    @Bean(name = "secondService")
    public MyService myService2() {
        return new MyService();
    }
}