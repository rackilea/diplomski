public void setUp() throws MalformedURLException {
                Properties p = PropertiesUtil.getProperties();
                //File file = new File(p.getProperty("webdriver.path"));
                //System.setProperty(p.getProperty("webdriver.type"), file.getAbsolutePath());
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                //driver = new ChromeDriver();
                WebDriver driver = new RemoteWebDriver(new java.net.URL("http://seleniumHubIp:4444/wd/hub"), capability);
                driver.get(p.getProperty("host.address")+APLICATION_CONTEXT);
                LoginPage login = PageFactory.initElements(driver, LoginPage.class);
                login.setUsuarioTextField(p.getProperty("usuario.selenium.login"));
                login.setSenhaPasswordField(p.getProperty("usuario.selenium.password"));
                home = login.submit();
        }