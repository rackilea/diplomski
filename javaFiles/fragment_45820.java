import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JsoupDummy {
 public static void main(String[] args) throws IOException, ParseException {
    System.setProperty("webdriver.gecko.driver", "D:\\thirdPartyApis\\geckodriver-v0.19.1-win32\\geckodriver.exe");
    WebDriver driver = new FirefoxDriver();

    try {
        driver.get("https://chesstempo.com/chess-problems/15");
        Document doc = Jsoup.parse(driver.getPageSource());
        Elements elements = doc.select("span.ct-active-tag");
        for (Element element:elements){
             System.out.println(element.html());
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        /*write.flush();
        write.close();*/
        driver.quit();

    }
}
}