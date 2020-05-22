public class Hybrid_App {

public static void main(String[] args) throws MalformedURLException, InterruptedException{

    DesiredCapabilities capabilities = new DesiredCapabilities();

    capabilities.setCapability("deviceName", "Atom 2x");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("platformVersion", "5.1");

    capabilities.setCapability("appPackage","***YourHydridAppPkg****");
    capabilities.setCapability("appActivity", "****YourlauchableActivity***");

    AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    Thread.sleep(4000);

    Set<String> contextHandles = driver.getContextHandles();

    Map<String,String> hashMap= new HashMap<String,String>();

    for(String contextname:contextHandles){

        if(contextname.contains("NATIVE")){

            hashMap.put("native", contextname);

        }else{
            hashMap.put("webview", contextname);
        }
    }

    //native page - Native 
    driver.context(hashMap.get("native"));

    WebDriverWait wait= new WebDriverWait(driver, 50);
    WebElement ele_voucher = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@class='android.view.View'][@index='9'][@content-desc='VOUCHERS']")));

    System.out.println(ele_voucher.isDisplayed());

    Thread.sleep(6000);
    ele_voucher.click();

    Thread.sleep(9000);

    //second page - Native
    driver.context(hashMap.get("native"));

    Thread.sleep(5000);
    driver.findElementByXPath("//*[@class='android.view.View'][@index='17'][@content-desc='REDEEM']").click();

    Thread.sleep(8000);

    System.out.println("----Third page----"+" uname,pwd element");

    //third page - Webview
    driver.context(hashMap.get("webview"));

    Thread.sleep(6000);

    driver.findElementByXPath("//input[@class='x-input-email'][@type='email'][@name='email']").sendKeys("descbatch@gmail.com");

    WebElement ele_pwd = driver.findElementByXPath("//input[@class='x-input-password'][@type='password'][@name='password']");

    ele_pwd.click();
    Thread.sleep(4000);
    ele_pwd.sendKeys("12345");

    Thread.sleep(6000);


    System.out.println("----Third page----"+" Sign in element");

    //fourth page - Native
    driver.context(hashMap.get("native"));

    Thread.sleep(6000);
    driver.findElementByXPath("//*[@class='android.view.View'][@index='69'][@content-desc='SIGN IN']").click();
    Thread.sleep(6000);

    driver.sendKeyEvent(AndroidKeyCode.BACK);


}