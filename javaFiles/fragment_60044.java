public class SignIn_ActionBuilder {

    public static void Execute(WebDriver driver) throws Exception{

       driver.get(Constant.URL);

       driver.manage().window().maximize();

       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

       Home_Page.Skip_Advertising(driver).click();

       Home_Page.lnk_MyAccount(driver).click();

       LogIn_Page.txtbx_UserName(driver).sendKeys(Constant.Username);

       LogIn_Page.txtbx_Password(driver).sendKeys(Constant.Password);

       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

       LogIn_Page.btn_LogIn(driver).click();

       driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
   }
}