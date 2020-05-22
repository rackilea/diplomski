import org.openqa.selenium.JavascriptExecutor;
WebDriver driver = new FirefoxDriver();
JavascriptExecutor jse = (JavascriptExecutor)driver;
...
public void scrollDownPage( int pix ) {
    if ( pix <= 0 || pix > 1000 ) pix = 250;
    jse.executeScript("scroll(0, pix)");
}