public class EmailManagerTest{

    private EmailManager emailManager;

    @Test
    public void testEmailContent(){
        emailManager = spy(new EmailManager());
        doReturn("new location").when(emailManager).getImageLocation("someImage");
        String result = emailManager.getEmailContent("Hello World", "someImage");
        // assertions ...
    }
}