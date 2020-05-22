public class Test2 extends TestBase {

    @Test
    public void goToStackOverflow() {
        System.out.println("SO!");
        String stackOverflowAddress = "http://stackoverflow.com/";
        webDriver.get().get(stackOverflowAddress);
        assertTrue(webDriver.get().getCurrentUrl().contains("stack"), "We are on SO!");
    }
}