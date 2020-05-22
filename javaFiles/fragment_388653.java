WebDriver driver = new FirefoxDriver();
       driver.get("http://www.google.com");

       List<WebElement> list=driver.findElements(By.xpath("//*[@href or @src]"));

       for(WebElement e : list){
           String link = e.getAttribute("href");
           if(null==link)
               link=e.getAttribute("src");
           System.out.println(e.getTagName() + "=" + link);
       }