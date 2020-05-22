public void CheckSite(String textToBeChecked, String error,WebDriver driver)
        throws Exception {
    Object test = (((JavascriptExecutor) driver)
            .executeScript("return document.body.innerHTML;"));
    if (!((String) test).contains(textToBeChecked)) {
        fail(error);
    }
}