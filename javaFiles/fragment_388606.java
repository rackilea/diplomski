@RunWith(PowerMockRunner.class)
@PrepareForTest(NotificationHelper.class)
@PowerMockRunnerDelegate(PowerMockRunnerDelegate.DefaultJUnitRunner.class) // for @Rule
public class NotificationHelperTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        PowerMockito.spy(NotificationHelper.class);
    }

    @Test
    public void testSendNotificationForEmail() throws Exception {
        NotificationHelper.sendNotification("email");

        PowerMockito.verifyStatic();
        NotificationHelper.notify("email", "Hi, An account is created with our website using your email id. This is a notification regarding the same.");
    }

    @Test
    public void testSendNotificationForMobile() throws Exception {
        NotificationHelper.sendNotification("mobile");

        PowerMockito.verifyStatic();
        NotificationHelper.notify("mobile", "Created new account");
    }

    @Test
    public void testSendNotification() throws Exception {
        this.expectedException.expect(Exception.class);
        this.expectedException.expectMessage("id is neither phone number nor email id");
        NotificationHelper.sendNotification("foobar");
    }
}