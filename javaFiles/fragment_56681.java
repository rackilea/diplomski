@RunWith(MockitoJUnitRunner.class)
public class HelloworldcontrollerTest {
    private Helloworldcontroller hcontroller;

    @Mock
    private Helloworldservice hservice;

    @Before
    public void setup() {
        hcontroller = new Helloworldcontroller(hservice);

        Mockito.when(hservice.greetingSB(any(Map.class)))
                .thenReturn("Hello, somebody!!!");
    }

    @Test
    public void testGreeting() {
        Assert.assertEquals("Hello, somebody!!!", hcontroller.sayHelloSB());
    }
}