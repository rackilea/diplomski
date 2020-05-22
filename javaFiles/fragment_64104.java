public class PageBase extends SeleniumBase {

public CustomerHomePage customerHomePage()
{
    return PageFactory.initElements(driver, CustomerHomePage.class);
}