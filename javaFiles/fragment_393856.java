Keys key;
switch (performAction) {
    case "ArrowDown":
        key = Keys.ARROW_DOWN;
        break;
    case "ArrowLeft":
        key = Keys.ARROW_LEFT;
        break;
    ...
    default:
        throw new IllegalArgumentException("Unknown action: " + performAction);
}

CommonFunctions.silentWait(1);
actionToE.moveToElement(currentObject).perform();

if (CommonFunctions.isElementDisplayed(currentObject)) {
    if (CommonFunctions.isElementEnabled(currentObject)) {
        if (!actionPar.isEmpty()) {
            int intActionPar = Integer.parseInt(actionPar);
            for (int i = 0; i < intActionPar; i++) {
                currentObject.sendKeys(key);
            }
        } else {
            currentObject.sendKeys(key);
        }
        isActionSuccess = true;
    }
}