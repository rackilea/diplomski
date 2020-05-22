@BeforeClass
public static void setUp() throws Exception {

    // ...

    cap.setPlatform(Platform.ANY);
    RemoteWebDriver driver = new RemoteWebDriver(new URL("http://51.19.210.111:5555/wd/hub"), cap);

    // ...   
}