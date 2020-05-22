@RunWith(AndroidJUnit4.class)
public class BundleControllerEspressoTest {

private Router router;
private ControllerBundleData controllerData;

@Rule
public ActivityTestRule<BundleConductorActivity> testRule = new ActivityTestRule<>(BundleConductorActivity.class);

@Before
public void setUp() {
    controllerData = new ControllerBundleData();
    Bundle bundle = new Bundle();
    bundle.putSerializable(YOUR_BUNDLE_KEY, controllerData);

    Activity activity = testRule.getActivity();
    activity.runOnUiThread(() -> {
               router = testRule.getActivity().getRouter();
               router.setRoot(RouterTransaction.with(new BundleController(bundle)));
           });
}

@Test
public void titleIsDisplayed() {
    onView(withText("Super Awesome Title")).check(matches(isDisplayed()));
    }
}