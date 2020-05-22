@RunWith(RobolectricTestRunner.class)
public class ActivityTest {

    private ActivityTest  activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(ActivityTest.class);
    }

    @Test
    public void shouldNotBeNull() {
        assertNotNull(activity);
    }

    @Test
    public void shouldHaveWelcomeFragment() {
        assertNotNull(activity.getFragmentManager().findFragmentById(R.id.welcome_fragment));
    }
}