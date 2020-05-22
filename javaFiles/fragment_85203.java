@Service
class A {
    private String importantValue = "stringvalue";

    @Autowire
    private B b;

    @PostConstruct
    public void initB() {
        b.importantValueFromA = this.importantValue;
    }
}