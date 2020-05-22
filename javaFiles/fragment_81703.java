public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new FirefoxDriver();
    driver.get("http://www.timesjobs.com");
    driver.findElement(By.linkText("Sign In")).click();
    Thread.sleep(10000);
    driver.switchTo().frame("GB_frame1");
    driver.switchTo().frame("GB_frame");

    WebElement we1 = driver.findElement(By.name("j_username"));
    we1.sendKeys("xyzusername@xyzcompany.com");
}