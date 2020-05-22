private boolean performAction(Keys key, Xxx currentObject) {
    CommonFunctions.silentWait(1);
    actionToE.moveToElement(currentObject).perform();

    if (CommonFunctions.isElementDisplayed(currentObject)) {
        if (CommonFunctions.isElementEnabled(currentObject)) {
            if (!actionPar.isEmpty()) {
                int intActionPar = Integer.parseInt(actionPar);
                for (int i = 0; i < intActionPar; i++) {
                    currentObject.sendKeys(keys);
                }
            } else {
                currentObject.sendKeys(keys);
            }
            return true;
        }
    }
    return false;
}