public boolean waitForURLToMatch(String expectedURL, int waitTime){
    Wait<WebDriver> wait = new WebDriverWait(driver, waitTime);
    Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
        public Boolean apply(WebDriver driver) {
            String currentURL = driver.getCurrentUrl();
            if(currentURL.equals(expectedURL))
            {
                truefalse = true;
                return truefalse;
            }
            truefalse = false;
            return truefalse;
        }
    };
    try{
        wait.until(function);
    } catch (TimeoutException e){   
    }
    return truefalse;
}