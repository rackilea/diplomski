//test doubles
String testDoubleApi;

//system under test
SomeClass someClass;

@Before
public void setUp() throws Exception {
    String testDoubleApi = "testDouble";
    Injector injector = Guice.createInjector(new Module() {
        @Override
        protected void configure(Binder binder) {
            binder.bind(String.class).annotatedWith(Names.named("api")).toInstance(testDouble);
        }
    });
    injector.inject(someClass);
}