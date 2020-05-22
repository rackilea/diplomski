void user_selects_combo_item(String comboBoxId, String itemToSelect) {
    ComboBox<?> actualComboBox = lookupControl(comboBoxId);

    // Find and click only on arrow button. This is important for editable combo-boxes.
    for (Node child : actualComboBox.getChildrenUnmodifiable()) {
        if (child.getStyleClass().contains("arrow-button")) {
            Node arrowRegion = ((Pane) child).getChildren().get(0);
            robot.clickOn(arrowRegion);
            Thread.sleep(100); // try/catch were skipped for shorter code.
            robot.clickOn(itemToSelect);
        }
    }
    Assert.fail("Couldn't find an arrow-button.");
}

private <T extends Node> T lookupControl(String controlId) {
    T actualControl = robot.lookup(controlId).query();
    assertNotNull("Could not find a control by id = " + controlId, actualControl);

    return actualControl;
}