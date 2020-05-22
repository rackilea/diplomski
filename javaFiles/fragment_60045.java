public class Sobet_WBG_YiWanCai {
public WebDriver driver;

@Test(description = "WBG亿万彩 - 后三码" , enabled = true)
  public void f() throws Exception {
      try{
          //Create the driver instance here.
          driver = new FirefoxDriver();
          SignIn_ActionBuilder.Execute(driver);
          ProductSelectionConfirmation_Action.ThreeDigit_Execute(driver);
          Home_Page.lnk_LogOut(driver);
          Home_Page.btn_LogOutDialog(driver);
          driver.close();
      }catch (Exception e){

          Log.error(e.getMessage());
          throw (e);
      }

  }
}