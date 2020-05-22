WebElement day_dropdown = driver.findElement(By.id("dwfrm_profile_customer_dayofbirth"));
    Select day = new Select(day_dropdown);
    day.selectByVisibleText("05");
    WebElement month_dropdown = driver.findElement(By.id("dwfrm_profile_customer_monthofbirth"));
    Select month = new Select(month_dropdown);
    month.selectByVisibleText("05");
    WebElement year_dropdown = driver.findElement(By.id("dwfrm_profile_customer_yearofbirth"));
    Select year = new Select(year_dropdown);
    year.selectByVisibleText("1990");