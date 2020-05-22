public class Atest {
    private A a;

    @Mock
    private IClient mockAClient;

    @Mock
    private IClient mockBClient;

    @Before
    public void prepare() {
        a = new A(new HashSet<>(Arrays.asList(mockAClient, mockBClient));
    }

}