public void start(Stage stage) {
    Pane root = new Pane();

    final int count = 7; //number of rectangles

    NumberBinding minSide = Bindings
            .min(root.heightProperty(), root.widthProperty())
            .divide(count);

    for (int x = 0; x < count; x++) {
        for (int y = 0; y < count; y++) {
            Rectangle rectangle = new Rectangle(0, 0, Color.LIGHTGRAY);

            rectangle.xProperty().bind(minSide.multiply(x));
            rectangle.yProperty().bind(minSide.multiply(y));
            rectangle.heightProperty().bind(minSide.subtract(2));
            rectangle.widthProperty().bind(rectangle.heightProperty());
            root.getChildren().add(rectangle);
        }
    }

    stage.setScene(new Scene(root, 500, 500));
    stage.show();
}