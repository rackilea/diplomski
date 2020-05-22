for (int i = 0; i < q; i++) {            
        try {
            WebElement element = SeleniumCommands.findElementsByCss(ASSESSMENTANSWER)[i];
            element.click();
        } catch (StaleElementReferenceException e) {
            Thread.sleep(200); // optional, but just to be safe...
            WebElement element = SeleniumCommands.findElementsByCss(ASSESSMENTANSWER)[i];
            element.click();
        }            
    }