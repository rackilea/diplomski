public class naukri {
        WebDriver driver = new FirefoxDriver();

        @Test
        public void pagelaunch() throws InterruptedException{        
          driver.get("http://www.naukri.com");
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          String parenthandle = driver.getWindowHandle();
          String parent = driver.getWindowHandle();

          //close all the pop ups
          Set<String> pops=driver.getWindowHandles();
          Iterator<String> it =pops.iterator();
          while (it.hasNext()){    
             String popupHandle=it.next().toString();
             if(!popupHandle.contains(parent))
             {
             driver.switchTo().window(popupHandle);
             System.out.println("Pop Up Title: "+ driver.switchTo().window(popupHandle).getTitle());
             driver.close();
             }
          }

          System.out.println("the system handle is"+parenthandle);
          driver.switchTo().window(parenthandle);
          WebDriverWait wait = new WebDriverWait(driver,10);
          WebElement login = driver.findElement(By.xpath("//a[@title='Jobseeker Login']"));
          wait.until(ExpectedConditions.elementToBeClickable(login));
          //to click on login button and proceed to login to the application
          driver.findElement(By.xpath("//a[@title='Jobseeker Login']")).click();
          Thread.sleep(3000);

          for(String winhandle:driver.getWindowHandles())
          {
              System.out.println("login: "+winhandle);  
              driver.switchTo().window(winhandle);
          }
          Thread.sleep(3000);   
          driver.findElement(By.xpath("//a[@id='uSel']")).click();
          driver.findElement(By.xpath(".//*[@id='uLogin']")).sendKeys("anand_qa");
          driver.findElement(By.xpath(".//*[@id='pLogin']")).sendKeys("test1234");
          driver.findElement(By.xpath(".//*[@id='lgnFrm']/div[7]/button")).click();
          //driver.switchTo().window(parenthandle);
        } 
}