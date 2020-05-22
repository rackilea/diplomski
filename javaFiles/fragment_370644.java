public class CarTestCase{

    private Configuration configuration;

    private Engine engine;

    private Car car;

    @Before
    public void setUp(){
        configuration = mock(Configuration.class);
        engine = spy(new Engine(configuration));
        car = new Car(engine);
    }

    @Test
    public void test(){

       Mockito.when(configuration.getProperties("")).return("Something");
       car.drive();
    }

}