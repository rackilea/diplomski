@Component
@PropertySource("classpath:test.properties")
@ConfigurationProperties
public class GlobalProperties {

    private int age;
    private String name;

    //getters and setters
}