@Config(
    url="http://wordpress.org",
    browser = Browser.CHROME
)
public class GettingStarted extends AutomationTest {
    @Test
    public void testSeleniumHQ() {
        navigateTo("http://docs.seleniumhq.org")
        .click("a[title='Selenium Projects']")
        .click(By.xpath("//div[contains(@class, 'bigMenu')]//p/a[@href='webdriver/']"))
        .validateTextPresent("Selenium 1.0 + WebDriver = Selenium 2.0")
        ;
    }
}