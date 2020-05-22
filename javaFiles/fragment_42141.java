@RunWith(MockitoJUnitRunner.class)
public class RegistrationTest {
    private RegistrationController controller;

    private RegistrationIpCache spyRegistrationIpCache; //this is the dependencies that you need to spy

    @Before
    public void setUp() throws Exception {
        spyRegistrationIpCache = spy(realInstanceOfregistrationIpCache);

        controller = new RegistrationController(registrationIpCache, realInstanceOfFormFactory);
    }
}