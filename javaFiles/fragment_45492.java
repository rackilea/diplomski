String Verifyregistration_Status = null;
String Verifyregistration_Message = null;

@Test
@Parameters({ "USERNAME", "NAME", "EMAIL", "CHOOSEPASS", "CONFIRMPASS" })
public void Execute(String UserName, String Name, String Email,
        String Choose_Pass, String Confirm_Pass) {

    // Below loop will execute two times
    // First Iteration , registration should be successful
    // Second Iteration Registration should fail saying "already registered" as i am using same data

    for (int i = 0; i < 2; i++) {

        Config.driver.findElement(By.linkText("Register")).click();
        Config.driver.findElement(By.id("signup_username")).sendKeys(
                UserName);
        Config.driver.findElement(By.id("field_1")).sendKeys(Name);
        Config.driver.findElement(By.id("signup_email")).sendKeys(Email);
        Config.driver.findElement(By.id("signup_password")).sendKeys(
                Choose_Pass);
        Config.driver.findElement(By.id("signup_password_confirm"))
                .sendKeys(Confirm_Pass);
        Config.driver.findElement(By.id("signup_submit")).click();
        // perform validation here
        boolean expvalue = Config.driver
                .findElement(
                        By.xpath("//input[@id='signup_username']/preceding-sibling::*[1]"))
                .isDisplayed();

        if (i==0) {

            Assert.assertFalse(expvalue);

        }else{

            Assert.assertTrue(expvalue);

        }


    }
}