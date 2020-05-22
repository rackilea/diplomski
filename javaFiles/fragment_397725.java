@RunWith(MockitoJUnitRunner.class)
public class ServiceTest{
    @Mock 
    private UrlProvider urlProvider;

    @InjectMocks
    private Service service = new Service();

    @Before
    public void init(){
        when(urlProvider.getUrl()).thenReturn("http://test.url");

    }
    ...
}