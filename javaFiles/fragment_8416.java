import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

    public class BaseTest {

    static TessBaseAPI api = new TessBaseAPI();

    @BeforeSuite
        public void beforeSuit() throws IOException {

            File screenshotsDirec = new File("target/screenshots");

            if (screenshotsDirec.exists())
                FileUtils.forceDelete(screenshotsDirec);

            FileUtils.forceMkdir(screenshotsDirec);

            System.out.println("Initializing TessEract library");

            if (api.Init("/opt/local/share", "eng") != 0) {
                System.err.println("Could not initialize tesseract.");
            }

        }

    public synchronized boolean verifyToastMessage(String msg)
                throws IOException {
            TakesScreenshot takeScreenshot = ((TakesScreenshot) driver);

            File[] screenshots = new File[5];

            for (int i = 0; i < screenshots.length; i++) {
                screenshots[i] = takeScreenshot.getScreenshotAs(OutputType.FILE);
            }

            String outText;

            Boolean isMsgContains = false;

            for (int i = 0; i < screenshots.length; i++) {
                PIX image = pixRead(screenshots[i].getAbsolutePath());
                api.SetImage(image);
                outText = api.GetUTF8Text().getString().replaceAll("\\s", "");
                System.out.println(outText);
                isMsgContains = outText.contains(msg);
                pixDestroy(image);
                if (isMsgContains) {
                    break;
                }
            }

            return isMsgContains;

        }

    @AfterSuite()
        public void afterTest() {

            try {
                api.close();
            } catch (Exception e) {
                api.End();
                e.printStackTrace();
            }

        }
    }