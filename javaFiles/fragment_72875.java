private static WebDriver driver;

public static WebDriver driver() {
    if (driver == null) {
        driver = new ChromeDriver();
    }
    return driver;
}