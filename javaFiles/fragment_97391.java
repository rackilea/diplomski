@Component
public final class WebDriverFactory {
   @Autowired @Lazy
   private CloseableChromeWebDriver chromeWebDriver;
   @Autowired @Lazy
   private CloseableFirefoxWebDriver firefoxWebDriver;