if (allInputFieldsElement.isEnabled()) {
        wait.until(ExpectedConditions.elementToBeClickable((allInputFieldsElement)));
        String inputText = "Automation text" + uuid;
        for (int i = 0; i < inputText.length(); i++) {
          allInputFieldsElement.sendKeys(inputText.substring(i, i+1));
          Thread.sleep(1000);
    }
 }