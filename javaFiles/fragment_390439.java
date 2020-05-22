@Component
class Test {
    private final ApplicationContext context;

    @Autowired
    public Test(ApplicationContext context) {
        this.context = context;
    }

    public void callRepository(String repName) /* here should come some throws declarations */ {
        Class<?> type = Class.forName(repName);
        Object instance = context.getBean(repName);

        type.getMethod("findById", int.class).invoke(instance, 7);
    }
}