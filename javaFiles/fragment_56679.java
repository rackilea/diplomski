@RunWith(MockitoJUnitRunner.class)
public class HelloworldcontrollerTest {
    @InjectMocks
    private Helloworldcontroller hcontroller = new Helloworldcontroller();

    @Mock
    private Helloworldservice hservice_mock;

    @Before
    public void setup() {
        Mockito.when(hservice_mock.greetingSB(any(Map.class)))
                .thenReturn("Hello, somebody!!!");
    }

    @Test
    public void testGreeting() {
        String h = hcontroller.sayHelloSB();
        Assert.assertEquals(h, "Hello, somebody!!!");
    }
}