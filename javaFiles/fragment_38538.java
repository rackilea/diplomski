@Component
public class TestClass {

    @Autowire
    private ConfigProperties properties;

    public void printSomething() {
       System.println(properties.getHostname());
       System.println(properties.getPort());
    }

}