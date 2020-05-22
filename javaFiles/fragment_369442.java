@FXML
private void initialize() {

    GraphicsContext gc = regularCanvas.getGraphicsContext2D();

    ReadOnlyDoubleProperty widthProperty = pane.widthProperty();
    ReadOnlyDoubleProperty heightProperty = pane.heightProperty();
    regularCanvas.widthProperty().bind(widthProperty);
    regularCanvas.heightProperty().bind(heightProperty);

    regularCanvas.widthProperty().addListener((obs, oldWidth, newWidth) -> drawArea(gc));
    regularCanvas.heightProperty().addListener((obs, oldHeight, newHeight) -> drawArea(gc));

    drawArea(gc);
}