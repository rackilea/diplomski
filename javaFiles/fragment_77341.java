public class ...... {

  private static Selenium selenium;

  @BeforeClass
  public static void initSelenium() {
     selenium = new DefaultSelenium(...); // or initialize it in any other way
  }

  @Test
  public void testA {...}

  @Test
  pulic void testB {...}

  @AfterClass
  public static void closeBrowsers() throws Exception { 
    selenium.stop(); 
  }
}