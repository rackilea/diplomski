public static ThreadLocal<WebDriver> driver;
driver=new ThreadLocal<WebDriver>()
                {
                    @Override
                    protected WebDriver initialValue()
                    {
                        return new FirefoxDriver(); //You can use other driver based on your requirement.
                    }
                };