public static void main(String[] args) {
    // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver",
            "D:\\eclipseProject\\StackOverFlow\\chromedriver_win32 (1)\\chromedriver.exe");

        // up-to year present i have copy pasted everything form your question 

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://jqueryui.com/datepicker/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content']/iframe")));
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        String Month_Present = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/span[1]")).getText();
        String Year_Present = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/span[2]")).getText();
        System.out.println(Month_Present);
        System.out.println(Year_Present);

        // now implementing code as per your question

        // SOLUTION FIRST 
        // first solution is that you can pass simply value in the
        // input date box as it is taking value simply just by typing 

        // driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("06/22/2015");

        // SOLUTION SECOND
        // there is no need to take Month and year separately 
        // hence talking them inside a single string 
        String Year_Month = driver.findElement(By.xpath(".//*[@class='ui-datepicker-title']")).getText();
        System.out.println(Year_Month);

        // click the previous year button only if current 
        // year and month  displayed is not May 2015

        for(int i =0;i<12;i++){
            // checking if year is 2015 or not
            Year_Month = driver.findElement(By.xpath(".//*[@class='ui-datepicker-title']")).getText();
            System.out.println(Year_Month);
            if(!Year_Month.equals("May 2015")){
                driver.findElement(By.xpath("//*[@class='ui-icon ui-icon-circle-triangle-w']")).click(); 
            }
        }

        // now as we are inside the desired year month we can select date now
        List<WebElement> dataForMonth4 = driver.findElements(By.xpath("//*[@data-month='4']/a"));
        System.out.println("Total available dates to select in this month : " + dataForMonth4.size());

        for(int i=0;i<dataForMonth4.size();i++){
            System.out.println("Date is : " + dataForMonth4.get(i).getText());
            // now implement the logic of date selection
            if(dataForMonth4.get(i).getText().equals("22")){
                dataForMonth4.get(i).click();
            }
        }
}