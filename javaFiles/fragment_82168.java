@ConstructorBinding
@ConfigurationProperties(prefix = "abc")
public class SystemProperties {

    private final String test;

    public SystemProperties(
            String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }
}