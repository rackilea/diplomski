public class demo extends parent {

    WebDriver driver = new FirefoxDriver(); 

    @Test

    public void launch() throws InterruptedException {

        driver.get("https://www.google.co.in");

        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        WebElement el = driver.findElement(By.xpath(".//*[@id='hplogo']"));
        el.click();
        Thread.sleep(10000);
        el.sendKeys(Keys.CONTROL + "p"); // trying to invoke print pop up
        Thread.sleep(10000);
        r.keyPress(KeyEvent.VK_ESCAPE); //dismissing it by sending escape keys


    }
}