@Component
public class FooClass {
    @Value("${some.regex}")
    private String regex;

    private Pattern pattern;

    @PostConstruct
    public void init() {
        pattern = Pattern.compile(regex);
    }
    // rest of code here
}