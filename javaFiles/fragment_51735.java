import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "test")
public static class TestProperties {

    private String stringProperty;
    private Integer integerProperty;

    // getters and setters

}