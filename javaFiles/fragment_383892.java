@Component
@ConfigurationProperties(prefix = "somePrefix")
public class AClass {
    private final AnotherClass anotherClass;
    private final Map<String, Double> aMap = new HashMap<>();
    private final FooClass foo = new FooClass();

    public AClass(AnotherClass anotherClass) { ...}

    public Map<String, Double> getaMap() { ... }

    public FooClass getFoo() { ... }

}