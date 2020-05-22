public int verifyCompletion() {
    int uncompletedCounter = 0;

    for (int i = 0; i < 10; i++) {
        String selector  = "_ctl" + i + "_ContentPlaceHolder1_eoiSectionSummary_individualRepeater__ctl" + i + "_sectionRepeater__ctl" + i + "_isCompleteLabel";
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id(selector)));
        String elementText = driver.findElement(By.id(selector)).getText();

        System.out.println(selector);
        System.out.println(elementText);

        boolean sectionCompleted =text.equalsIgnoreCase("Yes");
        if (!sectionCompleted) {
            uncompletedCounter++;
        }
    }
    return uncompletedCounter;
}