public void initialize() {
    VBox vbox = new VBox();
    ...
    AnchorPane.setTopAnchor(vbox, 10.0); // obviously provide your own constraints
    leftAnchorPane.getChildren().add(vbox);
}