@Test
public void test1() throws Exception {
    System.setProperty("webdriver.chrome.driver", "t:\\Others\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    String url = "http://www.upmandiparishad.in/commodityWiseAll.aspx";

    driver.get(url);
    Thread.sleep(5000);

    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddl_commodity"))).selectByVisibleText("Paddy");
    Thread.sleep(5000);

    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txt_rate")).sendKeys("27/03/2014");
    Thread.sleep(5000);

    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btn_show")).click();
    Thread.sleep(5000);

    driver.close();