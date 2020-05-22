public static void waitForPageToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 15);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript(
                    "return document.readyState"
                ).equals("complete");
            }
        }); 

    }