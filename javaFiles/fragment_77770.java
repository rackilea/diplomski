WebDriver driver = new FirefoxDriver();  
    driver.get("https:www.google.com");
    WebDriverWait wait = new WebDriverWait(driver, 5 );

    try{

    if(wait.until(ExpectedConditions.alertIsPresent())==null)
    {
    System.out.println("alert was not present");
    }else{
        Alert alert = driver.switchTo().alert(); 
        alert.accept();
        System.out.println("alert was present");
        }

    }catch(Exception e){
        System.out.println("ignored alret not present exception" +e.getMessage());
    }


}