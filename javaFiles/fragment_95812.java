driver.get("https://www.shareinvestor.com/my");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        /*String script = "function updateHTML(countdown, value) {" +
                "var elem = document.getElementById('countdown');"+
                "if(typeof elem !== 'undefined' && elem !== null) {"+
                " document.getElementById('countdown').innerHTML = value;"+
                "}"+
                "}";

        ((JavascriptExecutor) driver).executeScript(script);*/

        WebElement login_button = driver.findElement(By.xpath("//div[@id='sic_loginContainer']/div/div[@class='sic_logIn-bg']/a"));

        login_button.click();

        driver.findElement(By.xpath("//input[@id='sic_login_header_username']")).sendKeys("debanjan");
        driver.findElement(By.xpath("//input[@id='sic_login_header_password']")).sendKeys("5786");
        driver.findElement(By.xpath("//input[@id='sic_login_submit']")).click();