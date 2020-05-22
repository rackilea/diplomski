public class FramesSample {

static WebDriver driver = new FirefoxDriver();     <-------

    public static void main(String[] args) Exception
    {

    driver.manage().window().maximize();
    driver.get("url");
    //TODO stuff
    new FramesSample().switchToFrame("parentid", "childid");

    }
    public void switchToFrame(String ParentFrame, String ChildFrame)
    {
    try {
    driver.switchTo().frame(ParentFrame).switchTo().frame(ChildFrame)
    //TODO Stuff
   }
   }