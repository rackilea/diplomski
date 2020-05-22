public class Test1 extends TestBase {

    @Test
    public void goToGoogle() {
        System.out.println("Google");
        String googleURL = "http://google.com/";
        webDriver.get().get(googleURL);
        assertTrue(webDriver.get().getCurrentUrl().contains("google"), "We are on Google!");
    }
}