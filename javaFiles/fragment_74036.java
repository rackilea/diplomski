WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in/maps?source=tldso");
        Thread.sleep(3000);
        driver.findElement(By.id("searchboxinput")).sendKeys("Kora");
        Thread.sleep(3000);
        List<WebElement> autoSuggestions=driver.findElement(By.className("sbsb_b")).findElements(By.tagName("li"));
        for (WebElement suggestions : autoSuggestions) {
            if (suggestions.getText().contains("Koramangala Police Station")) {
                suggestions.click();
                Thread.sleep(3000);
                break;
            }
        }
        driver.quit();