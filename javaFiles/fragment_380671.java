public class ServiceTest {

    private Service service;

    private OtherService otherServiceMock;

    @Before
    public void setUp() {
        otherServiceMock= mock(OtherService.class);
        service = new Service();
        service.setOtherService(otherServiceMock);
    }

    @Test
    public void testSomeMethodBlaBla(){...}
}