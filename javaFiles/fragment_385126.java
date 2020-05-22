Scanner scan= new Scanner(System.in);
    String textID= scan.nextLine(); //Enter ID Here
    String textDesc= scan.nextLine();//Enter Desc Here
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Testing\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.navigate().to("https://jpetstore.cfapps.io/catalog");
            driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
            driver.findElement(By.name("username")).sendKeys("Testing6738788");
            driver.findElement(By.name("password")).sendKeys("test@123");
            driver.findElement(By.id("login")).click();

        driver.findElement(By.xpath("//div[@id='SidebarContent']/a[contains(@href,'FISH')]/img")).click();
        driver.findElement(By.xpath("//td[contains(text(),'Angelfish')]//preceding-sibling::td//a")).click();
       List<WebElement> tablelist = driver.findElements(By.xpath("//div[@id='Catalog']//tr/td"));
       System.out.println(tablelist.size());

     for(int i=0;i<tablelist.size();i++)
    {
        String gotvalues = tablelist.get(0).getText();
        String gotvaluesdesc = tablelist.get(2).getText();

       // System.out.println("Values got from the table  " +gotvalues  );
        if(gotvalues.trim().equalsIgnoreCase(textID) && gotvaluesdesc.trim().equalsIgnoreCase(textDesc))

        {
            System.out.println("Element present ID: " + gotvalues + " Desc :" + gotvaluesdesc);
            break;
        }