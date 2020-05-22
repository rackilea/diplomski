package myproject;

import java.io.*;
import java.util.*;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class MyProjectBaseTest {    
    protected static WebDriver driver;

    @Before
    public void before() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://myapp");
        login();
    }

    @After
    public void after() {
        logout();
    }

    private void login() {
        Map<String, String> data = readData("/path/to/testdata/login.json");

        Set<String> keys = data.keySet();
        for (String key : keys) {
            WebDriverWait wait = new WebDriverWait(driver, 20L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(key)));
            final WebElement we = driver.findElement(By.id(key));
            if ("input".equals(we.getTagName())) {
                we.clear();
                we.sendKeys(data.get(key));
            }
            //else if "button".equals(we.getTagName())
        }
    }

    private void logout() {
        //logout code ...
    }

    private Map<String, String> readData(String filename) {
        Map<String, String> data = new HashMap<String, String>();

        InputStream is = null;
        String key = null;        
        try {
            is = new FileInputStream(filename);
            JsonParser parser = Json.createParser(is);
            while (parser.hasNext()) {
                Event e = parser.next();
                if (e == Event.KEY_NAME) {
                    key = parser.getString();
                }
                if (e == Event.VALUE_STRING) {
                    data.put(key, parser.getString());
                }
            }
            parser.close();
        }
        catch (IOException e) {
            //error handling
        }
        finally {
            //close is
        }

        return data;
    }

}