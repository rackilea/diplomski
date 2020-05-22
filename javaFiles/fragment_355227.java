@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestMyApplication.class)
public class MainActivityTest {

    @Inject
    Picasso picasso;

    @Before
    public void setup() {
        ((TestMyApplication)RuntimeEnvironment.application).getOrCreateApplicationComponent().inject(this);
        Mockito.when(picasso.load(Matchers.anyString())).thenReturn(Mockito.mock(RequestCreator.class));
    }


    @Test
    public void test() {
        Robolectric.buildActivity(MainActivity.class).create();
    }

}