@Component
public class MyConfig {
    @Value("${identifier:asdf1234}")
    public String identifier;

    public String getIdentifier() {
        return identifier;
    }
}