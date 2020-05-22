@Configuration
@PropertySource("classpath:application_variable.properties")
@ConfigurationProperties
public class VariableProperties {

    private String foo;
    private String bar;

    // getters and setters
}