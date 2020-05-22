@Override
public void start(Stage stage) {
    Group root = new Group();

    Polygon triangle = new Polygon(300d, 100d, 600d, 150d, 500d, 300d);
    root.getChildren().add(triangle);

    Scene scene = new Scene(root, 900, 500);

    for (double x = 65; x < scene.getWidth(); x += 65) {
        for (double y = 65; y < scene.getHeight(); y += 65) {
            Circle circle = new Circle(x, y, 10);

            root.getChildren().add(circle);

            Shape intersection = Shape.intersect(circle, triangle);

            //Setting the color of the circle
            circle.setFill(intersection.getBoundsInLocal().getWidth() == -1 ? Color.BLACK : Color.RED);
        }
    }

    triangle.setFill(Color.TRANSPARENT);
    triangle.setStroke(Color.RED);
    triangle.toFront();

    stage.setTitle("Scale transition example");
    stage.setScene(scene);
    stage.show();
}