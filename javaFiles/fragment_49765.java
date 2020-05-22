@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @Mock
    private ServiceProxy proxy;

    @InjectMocks
    private Service service;

    @Test
    public void test() {
        assertNotNull(service);
        assertNotNull(proxy);
    }
}