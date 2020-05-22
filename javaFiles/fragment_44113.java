import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Scrape {
    public static void doScrape(String[] urls) {
        try{
            for(String url : urls) {
                //Create new Chromedriver, set file download path, allow the download popup to be automatically accepted,and merge the properties into chromedriver
                System.setProperty("webdriver.chrome.driver", "/Users/damienbell/chromedriver");
                String downloadFilepath = "/Users/damienbell/automation-testing";

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--test-type");
                //options.addArguments("--headless");
                options.addArguments("--disable-extensions");

                //Instantiate above options in driverService
                ChromeDriverService driverService = ChromeDriverService.createDefaultService();
                ChromeDriver driver = new ChromeDriver(driverService, options);


                Map<String, Object> commandParams = new HashMap<>();
                commandParams.put("cmd", "Page.setDownloadBehavior");

                Map<String, Object> params = new HashMap<String, Object>();
                params.put("behavior", "allow");
                params.put("downloadPath", downloadFilepath);
                params.put("cmd", "Page.setDownloadBehavior");


                commandParams.put("params", params);
                ObjectMapper om = new ObjectMapper();
                CloseableHttpClient httpClient = HttpClients.createDefault();
                String command = null;
                try{
                    command = om.writeValueAsString(commandParams);
                }catch(JsonProcessingException jpe){ jpe.printStackTrace(); }
                String postURL = driverService.getUrl().toString() + "/session/" + driver.getSessionId() + "/chromium/send_command";
                HttpPost postRequest = new HttpPost(postURL);
                postRequest.addHeader("content-type", "application/json");
                postRequest.addHeader("accept", "*.*");
                try{
                    postRequest.setEntity(new StringEntity(command));
                    httpClient.execute(postRequest);
                }
                catch (UnsupportedEncodingException uee) { uee.printStackTrace(); }
                catch (IOException ioe) { ioe.printStackTrace(); }


                driver.get("https://x.atlassian.net/secure/Dashboard.jspa?selectPageId=11502");
                Thread.sleep(3000);  // Let the user actually see something!
                ((ChromeDriver) driver).findElementById("menu-sign-in").click();
                Thread.sleep(3000);
                ((ChromeDriver) driver).findElementById("google-signin-button").click();
                Thread.sleep(3000);
                ((ChromeDriver) driver).findElementById("identifierId").sendKeys("email@email.com");
                Thread.sleep(700);
                ((ChromeDriver) driver).findElementById("identifierNext").click();
                Thread.sleep(2000);
                driver.findElement(By.cssSelector("input[name=password]")).sendKeys(Secret.getPassword());
                Thread.sleep(600);
                ((ChromeDriver) driver).findElementById("passwordNext").click();
                Thread.sleep(10000);
                driver.get(url);
                Thread.sleep(56000);
                File[] files = new File("/Users/user/automation-testing").listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File path) {
                        if (path.isFile()) {
                            ParseCSV.doParse(path);
                            path.delete();
                            return true;
                        }
                        else{
                            System.out.println("Failure");
                        }
                        return false;
                    }
                });
                driver.quit();
            }
        }catch( java.lang.InterruptedException inter ){ System.err.println("Thread.sleep broke something, wtf"); inter.printStackTrace(); }
    }
}