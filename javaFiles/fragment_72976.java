WebElement  login = driver.findElement(By.id("dijit_form_Button_1_label"));

if(login.isDisplayed()){
    login.click();
    Reporter.log("Login Form Submitted  | ");
} else {
    Reporter.log("Login Failed  | ");
    Assert.fail("Login was not displayed");
}