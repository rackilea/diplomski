public class FlagsTest extends WithApplication {

    private SomethingUsingFlagDAO something;

    @Before
    public void setUp() {
        Injector injector = this.provideApplication().injector();
        this.something = injector.instanceOf(SomethingUsingFlagDAO.class);
    }

    @Override
    protected Application provideApplication() {
        Application application = new GuiceApplicationBuilder()
                .in(new Environment(new File("./"), this.getClass().getClassLoader(), Mode.TEST))
                .bindings(bind(FlagDAO.class).to(FlagDAOInMemory.class))
                .bindings(bind(SomethingUsingFlagDAOInterface.class).to(SomethingUsingFlagDAO.class))
                .build();

        return application;
    }
}