...
import net.thucydides.core.pages.components.FileToUpload;

public class PerformTheUpload  implements Task {

    private WebDriver driver;

    public PerformTheUpload (WebDriver driver){
        this.driver = driver;
    }

    public static PerformTheUpload onTheField(WebDriver driver) {
        return instrumented(PerformTheUpload.class, driver);
    }

@Override public <T extends Actor> void performAs(T actor) {        
        actor.attemptsTo(WaitUntil.the(UPLOAD_SOURCE_FILES_TARGET, isVisible()));
        myUploadFile(driver);
    }

    public void myUploadFile(WebDriver driver){
        WebElement webElement = getUploadWebElementById("uploadSourceFiles", driver);
        FileToUpload fileToUpload = new FileToUpload(driver, TEST_FILE);
        fileToUpload.fromLocalMachine().to(webElement);
    }

}

    //in the page class
    public static WebElement getUploadWebElementById(String id, WebDriver driver) {
        return driver.findElement(By.id(id));
    }