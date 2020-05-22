@Test
public void SignIn() throws IOException {
    driver=LoadBrowser();
    LoadPropFile();
    driver.get(prop.getProperty("test_website"));
    POM_HomePage pomHome=new POM_HomePage(driver);
    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
    if (pomHome.clickMyAccount().isDisplayed()) {
            pomHome.clickMyAccount().click();
    }
    if (pomHome.clickLogin().isDisplayed()) {
        pomHome.clickLogin().click();
    }
}