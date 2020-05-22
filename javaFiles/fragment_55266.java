private boolean wAit(String match)
    {
    try
        {
        (new WebDriverWait(driver, 30))
            .until(ExpectedConditions.presenceOfElementLocated (By.xpath(match)));
        return true;
        }
    catch (NoSuchElementException e) {
        return false;
    }
    }