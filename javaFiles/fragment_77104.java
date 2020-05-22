driver.get("https://www.redmine.org//projects//redmine//issues");
    driver.manage().window().maximize();
    driver.findElement(By.xpath(".//*[@class='per-page']/a[2]")).click();
    int num_of_clicks = Integer.parseInt(driver.findElement(
            By.xpath(".//*[@id='content']/p[1]/a[3]")).getText());
    for (byte i = 1; i < num_of_clicks; i++) {
        List<WebElement> records_in_page = driver.findElements(By.xpath(".//*[@class='list issues']/tbody/tr"));
        for (byte j = 0; j < records_in_page.size(); j++) {
            String Issue_Subject = driver.findElement(
                    By.xpath(".//*[@class='list issues']/tbody/tr[" + (j+1)
                            + "]/td[5]")).getText();
            System.out.println(Issue_Subject);
        }
        driver.findElement(By.xpath(".//*[@class='next']")).click();
    }