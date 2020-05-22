@Before
public void setup() {
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    File clientSslCertificate = new File(
        classLoader.getResource("certificates/some-certificate.pfx").getFile());
    String certificatePassword = "superSecret";

    this.proxy = new SeleniumSslProxy(clientSslCertificate, certificatePassword);
    this.proxy.start();

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setProxy(proxy);
    this.webDriver = new ChromeDriver(chromeOptions);
}

@Test
public void pageTitleIsFoo() {
    // given
    String url = "http://myurl.lol";
    // NOTE: do not use https in the URL here. It will be converted to https by the proxy.

    // when
    this.webDriver.get(url);
    this.webDriver.manage().timeouts().implicitlyWait(5, SECONDS);

    // then
    WebElement title = this.webDriver.findElement(By.className("title"));
    assertEquals("Foo", title.getText());
}

@After
public void teardown() {
    this.webDriver.quit();
    this.proxy.stop();
}