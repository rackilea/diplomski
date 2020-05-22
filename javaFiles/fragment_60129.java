Button btn = new Button();
Rectangle rect = new Rectangle(400, 10);

// wrap contents in resizeable Nodes
SplitPane root = new SplitPane(new Pane(btn), new Pane(rect));

// place divider in the middle
root.setDividerPositions(0.5);
root.setOrientation(Orientation.VERTICAL);
root.getStyleClass().add("line-split");
root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

root.skinProperty().addListener((observable, oldValue, newValue) -> {
    // don't allow resizing
    newValue.getNode().lookupAll(".split-pane-divider").stream().forEach(divider -> divider.setDisable(true));
});

btn.setText("Say 'Hello World'");
btn.setOnAction((ActionEvent event) -> {
    System.out.println("Hello World!");
});