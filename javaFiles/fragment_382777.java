import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Amazon handling
 * @author wf
 *
 */
public class Amazon {
    FirefoxDriver driver = new FirefoxDriver();
    String root="https://www.amazon.de";

    /**
     * signIn
     * @throws Exception
     */
    public void signIn() throws Exception {
        // <input type="email" autocapitalize="off" autocorrect="off" tabindex="1" maxlength="128" size="30" value="" name="email" id="ap_email" /> 
        WebElement emailField=driver.findElement(By.id("ap_email"));
        // get user and password
        AmazonUser auser=AmazonUser.getUser();
        emailField.sendKeys(auser.getEmail());
        //  <input type="password" class="password" onkeypress="displayCapsWarning(event,'ap_caps_warning', this);" tabindex="2" size="20" maxlength="1024" name="password" id="ap_password" />
        WebElement passwordField=driver.findElement(By.id("ap_password"));
        passwordField.sendKeys(auser.getPassword()); 
        // signInSubmit-input
        WebElement signinButton=driver.findElement(By.id("signInSubmit-input"));
        signinButton.click();
    }

  /**
   * navigate to the given path
   * @param path
   * @return
   * @throws Exception
   */
  public String navigate(String path) throws Exception {
    driver.get(root+path);
    String html=driver.getPageSource();
    if (html.contains("ap_signin_form")) {
      signIn();
    }
    html=driver.getPageSource();
    return html;
  }

  public void close() {
    driver.close();
    driver.quit();      
  }


}