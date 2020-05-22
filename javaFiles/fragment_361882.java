public abstract BaseBrowserTests {
     public abstract WebDriver getDriver();

     ... common tests...
}

public void ChromeTests {
     ... implement getDriver() to connect to Chrome ...

     ... you can add specific Chrome tests here ...
}