switch (performAction) {
    case "ArrowDown":
        isActionSuccess = performAction(Keys.ARROW_DOWN, currentObject);
        break;
    case "ArrowLeft":
        isActionSuccess = performAction(Keys.ARROW_LEFT, currentObject);
        break;
    ...
}