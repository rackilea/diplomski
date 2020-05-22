@Component
public class MainDriver {

    @Autowired
    private Environment env;

    @Autowired
    protected ConfigurableEnvironment cenv;

    @Autowired
    ApplicationContext ctx;

    @Autowired
    private SomeBean sb;


    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);

        MainDriver l = ctx.getBean(MainDriver.class);
        System.out.println("In main() the ctx is " + ctx);
        l.test();
    }

    public void test() {
        System.out.println("hello");
        sb.print();
    }
}