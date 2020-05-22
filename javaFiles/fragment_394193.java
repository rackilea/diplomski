private WebDriver driver;
private WebElement element;

private String URL;
private String elementName;
private String key;

public HelloGooglePage(String URL, String elementName, String key) {
    this.setURL(URL);
    this.setElementName(elementName);
    this.setKey(key);

    File file = new File("C:/Selenium/IEDriverServer.exe");
    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
    driver = new InternetExplorerDriver();
}

public void open(String URL) {
    driver.get(URL);
}

public void findElement(String elementName){
    element = driver.findElement(By.name(elementName));
}

public void sendKeys(String key){
    element.sendKeys(key);
}

@Test
public void submit(){
    element.submit();
    Assert.assertEquals("cheese - Google Search", driver.getTitle());
    driver.close();
}

public String getURL() {
    return URL;
}

public void setURL(String uRL) {
    URL = uRL;
}

public String getKey() {
    return key;
}

public void setKey(String key) {
    this.key = key;
}

public String getElementName() {
    return elementName;
}

public void setElementName(String elementName) {
    this.elementName = elementName;
}