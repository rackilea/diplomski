WebDriver driver = new FirefoxDriver();
        driver.get("http://www.tedbaker.com/uk/Womens/Sale/Accessories/Bags/c/sale_bags");

        String original_price = driver.findElement(By.xpath(".//*[@id='content']/div/div[4]/div[2]/div[2]/article/div[2]/header/div/ul/li[1]/del")).getText();
        String discount_price = driver.findElement(By.xpath(".//*[@id='content']/div/div[4]/div[2]/div[2]/article/div[2]/header/div/ul/li[2]")).getText();

        System.out.println(original_price);
        System.out.println(discount_price);

        String original_price_removecurrencysymbol = original_price.substring(1,original_price.length());
        String discount_price_removecurrencysymbol = discount_price.substring(1,discount_price.length());

        System.out.println(original_price_removecurrencysymbol);
        System.out.println(discount_price_removecurrencysymbol);

        int difference = Integer.parseInt(original_price_removecurrencysymbol) -Integer.parseInt(discount_price_removecurrencysymbol);

        System.out.println("Difference is:"+difference);