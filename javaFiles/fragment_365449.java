@RunWith(PowerMockRunner.class)
class BaseTest{
  @Rule
  public PowerMockRule powerMockRule = new PowerMockRule();
  @ClassRule
  public static final TestRule serviceInitializer = ServiceInitializer.INSTANCE;

  @Before
  public final void preTest() {
    // some code
  }

  @After
  public final void postTest() {
    //some code
  }
}