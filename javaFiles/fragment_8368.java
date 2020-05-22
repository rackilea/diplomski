public class UnderTest extends BaseClass {
    private LoginPageObjects lpage;

@BeforeTest
   public void setUp() throws Exception {
       lpage = PageFactory.initElements(driver, LoginPageObjects.class);
   }

@Test(description = "Email login")
public void f()
{
    Reporter.log("===dude===", true);
    lpage.click_signin_link();
    lpage.enter_uid("test@gmail.com");
    lpage.click_submit(); 
}

@Test(description = "fb login")
public void fe() throws InterruptedException
{
    Reporter.log("===dude===", true);
    lpage.click_fb_button();
    Thread.sleep(5000);

}