public class StatsTest extends AbstractTestCase {
    @Mock MultiPartEmail mockMultiPartEmail; // this mock will be used in the instantiaion of the class under test
    SendEmail sendEmail; // renamed as this is not a mock, it is the class under test

    // define some things we can make assertions against (probably in some other tests...)
    private static final StringBuilder BODY = new StringBuilder("body");
    private static final String SENDER = "sender@foo.com";
    private static final Collection<String> RECIPIENTS = Arrays.asList("recepient@foo.com")
    private static final String SUBJECT = "subject";
    private static final String HOSTNAME = "hostname";

    @Before
    public void setUp() throws Throwable {
        super.setUp();
        MockitoAnnotations.initMocks(this); // will instantiate "mockMultiPartEmail"

        // instantiate our class under test
        sendEmail = new SendEmail(BODY, SENDER, RECIPIENTS, SUBJECT, HOSTNAME, mockMultiPartEmail);
    }

    @Test(expected = ValidationException.class)
    public void testSendEmail() throws EmailException, IOException {
        // given some condition
        Mockito.when(mockMultiPartEmail.send()).thenThrow(new ValidationException("Could not send the Email."));

        // when the method under test is called
        sendEmail.sendEmail();

        // then the exception will be thrown (and you have correctly expected this on the @Test annotation)
    }
}