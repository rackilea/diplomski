public class WebDriverEventListenerTest {

    public static void main(String[] args) throws Exception {

        InternetExplorerDriver driver = new InternetExplorerDriver();
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        eventDriver.register(new EventHandler());

        eventDriver.get("<some webpage>");
        eventDriver.findElement(By.id("<some id>")).click();
        eventDriver.findElement(By.id("<some id>")).click();
    }

    public static class EventHandler extends AbstractWebDriverEventListener {

        @Override public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.printf("Driver Find By: %s\n", by);
            Times.start = System.currentTimeMillis();
        }

        @Override public void afterClickOn(WebElement element, WebDriver driver) {
            System.out.printf("Element Method Exit: %s\n", element);
            System.out.println("Time: " + (System.currentTimeMillis() - Times.start));
        }
    }

    public static class Times {
        public static long start = 0L;
    }
}