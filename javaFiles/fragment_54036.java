public EventFiringWebDriver initateWebDriverWithListener(){
    driver1 = new FirefoxDriver();
    EventFiringWebDriver driver = new EventFiringWebDriver(driver1);
    WebDriverListener eventListener = new WebDriverListener(driver);
    driver.register(eventListener);
}



public
class WebDriverListener implements WebDriverEventListener {
    public void afterNavigateTo(String url, WebDriver driver) {
        Logger.debug("Hit return ....");
        System.out.println("Hit return ....");
        try {
            System.in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Logger.debug("Proceeding further");
        System.out.println("Proceeding further");
    }
}

public class RunFromCommandLine{
    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
        TestNG testng = new TestNG(); 
        testng.setXmlSuites((List <XmlSuite>)(new Parser("src"+File.separator+"test"+File.separator+"resources"+File.separator+"xml_Suites"+File.separator+"TestNG.xml").parse()));     
        testng.setSuiteThreadPoolSize(1);
        testng.run();
    }
}