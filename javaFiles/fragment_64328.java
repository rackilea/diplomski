@Test
public void googlesearch()
{
     File path=new File("C:\\Utility\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
     System.setProperty("phantomjs.binary.path",path.getAbsolutePath());
     WebDriver driver= new PhantomJSDriver();
     driver.manage().window().maximize();
     driver.navigate().to("https://www.google.co.in/");
     System.out.println("inside Test");
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     System.out.println("Checking if the Search field is Enabled");
     driver.findElement(By.name("q")).isEnabled();
     System.out.println("Sending lol to Search field");
     driver.findElement(By.name("q")).sendKeys("lol");
     System.out.println("Clicking on Google Search button Next");
     driver.findElement(By.name("btnG")).click();
     System.out.println("Google Search Completed");
}