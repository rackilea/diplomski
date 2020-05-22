@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({SomeUtil.class})
public class SomeUtilTest {

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void doGet() {
        //......
        PowerMockito.whenNew(RestTemplate.class).withAnyArguments().thenReturn(restTemplate);
        //......
    }
}