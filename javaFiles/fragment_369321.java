transferButton.setOnAction(a -> {
    if (!onGridPane) {
        tab.setContent(null);
        gridPane.add(item, 0, 0);
        onGridPane = true;
        transferButton.setText("<-Move to Tab");
    } else {
        gridPane.getChildren().remove(item);
        tab.setContent(item);
        onGridPane = false;
        transferButton.setText("Move to GridPane->");
    }
});