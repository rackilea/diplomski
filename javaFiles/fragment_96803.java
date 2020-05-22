public class Screenshot {

File source;

public void takeScreenshot(WebDriver webDriver) {

    try {
        source = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);


    FileUtils.copyFile(source, new File ("/Users/joshuadunn/Desktop/claimsScreenShot.png"));
    System.out.println("Screenshot Taken!!!!");

    } catch (IOException e) {
        e.printStackTrace();
    } 
}

}