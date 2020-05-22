System.setProperty("webdriver.ie.driver",AbsoluteDriverPath); 
     webdriver=new InternetExplorerDriver();
     webdriver.get(URL);
     webdriver.manage().window().maximize();
     webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     webdriver.findElement(By.id("Text1")).sendKeys(user);
     webdriver.findElement(By.id("Password")).sendKeys(password);
     try{
        if (webdriver.findElement(By.id("ButtonLogin")).isDisplayed())
      {
        webdriver.findElement(By.id("ButtonLogin")).submit();
      }

     else{

        System.out.println("Submit button is not display");  
      }
    }
    catch(Exception e){
    System.out.println(e);
    }