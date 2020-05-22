public void waitForSomeElementToBeVisible(int timeout, final By... locators) throws Exception, TimeoutException {
        boolean found = false;

        try {
            waitUntilJSReady();
            setImplicitWait(0);
            WebDriverWait wait = new WebDriverWait(driver, timeout);

            ExpectedCondition<?>[] conditionsToEvaluate = new ExpectedCondition[locators.length];
            for (int i = 0; i < locators.length; i++) {
                conditionsToEvaluate[i] = ExpectedConditions.visibilityOfElementLocated(locators[i]);
            }

            found = wait.until(ExpectedConditions.or(conditionsToEvaluate));
        } catch (Exception e)  {
            // log...whatever
            throw e;
        } finally {
            setImplicitWait(SelTestCase.WAIT_TIME_OUT);
        }
        if (!found) throw new TimeoutException("Nothing found");
    }