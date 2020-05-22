@Component
//@Repository
public class RexportalConsole {
    @Autowired
    private SessionFactory sessionFactory;

    @PostConstruct
    public void foo() {
        System.out.println("postconstruct this:" + this);
        System.out.println("postconstruct this.sessionFactory:" + this.sessionFactory);
    }

    public static void main(String[] args) throws InterruptedException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("development");
        ctx.load("classpath:META-INF/spring-rexportal.xml");
        ctx.refresh();
        RexportalConsole rc = (RexportalConsole) ctx.getBean("rexportalConsole");
        System.out.println("main rc:" + rc);
        System.out.println("main rc.sessionFactory:" + rc.sessionFactory);
        System.out.println("main rc.getSessionFactory():" + rc.getSessionFactory());
        // rc.fail();
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    public void fail() {
        throw new SQLGrammarException("foo",null);
    }
}