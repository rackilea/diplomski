public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
  private MainActivity mMainActivity;

  public MainActivityTest() { super(MainActivity.class); }

  @Override
  protected void setUp() throws Exception {
    super.setUp();

    setActivityInitialTouchMode(true);

    MainActivity.setServiceWrapper(
      new MockedOTBService(getInstrumentation().getContext()).getService()
    );

    mMainActivity = getActivity();
  }
}