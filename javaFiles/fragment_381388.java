public class CapturingErrorMessage {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("ur url");

        // suppose u entered wrong i.e more then 128 character string in the input box

        driver.findElement(By.id("ctl00_CenterCPH_txtCityName")).sendKeys("more then 128 character");

        // talking under consideration that error message is displayed when you click on other textbox or simply on the screen.

        // suppose below line is to click on other option or some where on the screen 
        driver.findElement(By.id("ctl00_CenterCPH_txtCityName")).click();

        // now error message comes so before capturing the error message firstly try to 
        // identify if the span id with error message is present or not

        // simply in the if i am checking that if the size of the span tag with error is more then 0 or not if more then zero 
        // i.e error is present on the page
        if(driver.findElements(By.id("ct100_CenterCPH_revAlphaNum1Len")).size() > 0){
            String error = driver.findElements(By.id("ct100_CenterCPH_revAlphaNum1Len")).get(0).getText();
            System.out.println(error);
        }else{
            System.out.println("Element not present :  no error message");
        }   
    }
    }