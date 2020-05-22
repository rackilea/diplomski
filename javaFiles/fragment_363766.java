// for multiple separate test classes you need to share it among your project
public static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = 
    new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            // create a new instance for each thread
            return new ChromeDriver();
        }
    };

// get a WebDriver instance in your tests;
// when there is already an instance for the current Thread, it is returned;
// elsewise a new instance is created
WebDriver webDriver = WEB_DRIVER_THREAD_LOCAL.get();