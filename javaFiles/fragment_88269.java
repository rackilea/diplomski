public class TestScript01 extends AbstractHook {
        WebDriver driver = getdriver();

        @Given("^I want to open the gmail url on firefox$")
        public void i_want_to_open_the_Gmail_url_on_firefox() throws Throwable {

            driver.get("give some url");
        }
}