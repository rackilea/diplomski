public class MyFormPageObject {

    public MyFormPageObject enterLeadSource(String value) {
        driver.findElement(By.id("lead_source")).sendKeys(value);
        return this;
    }

    public MyFormPageObject enterDateClosed(String value) {
        driver.findElement(By.id("date_closed")).sendKeys(value);
        return this;
    }

    //...

}

// then in your test code
myFormPO.enterLeadSource("Existing Customer").enter("08/07/2013");