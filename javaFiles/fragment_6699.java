@Test
public void sentThreeMails() throws Exception {
    IApplicationMail mailCounter = new MailCounter();
    Application application = new Application(mailCounter);
    application.run(new String[] { "one", "two", "three" }, "Hello", "Blah!");

    assertEquals(3, mailCounter.calls);
}

class MailCounter implements IApplicationMail {
    public counter = 0;

    public sendMessage(String receiver, String message, String body) {
        counter++;
    }
}