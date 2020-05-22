@RunWith(AndroidJUnit4.class)
public class NoBundleControllerEspressoTest {

private Router router;

@Rule
public ActivityTestRule<NoBundleConductorActivity> testRule = new ActivityTestRule<>(NoBundleConductorActivity.class);

@Before
public void setUp() {
    Activity activity = testRule.getActivity();
    activity.runOnUiThread(() -> {
               router = testRule.getActivity().getRouter();
               router.setRoot(RouterTransaction.with(new NoBundleController()));
           });
}

@Test
public void titleIsDisplayed() {
    onView(withText("Super Awesome Title")).check(matches(isDisplayed()));
    }
}