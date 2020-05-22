@Component
@ConfigurationProperties(prefix="foo")
public static class Config {
    private final List<String> bar = new ArrayList<String>();
    public List<String> getBar() {
        return bar;
    }
}

@Component
public static class Test1 {
    @Autowired public Test1(Config config) {
        System.out.println("######## @ConfigProps " + config.bar);
    }
}