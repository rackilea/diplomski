private static Circle createCircle(double x, double y, double radius, double hitRadius) {
    Circle circle = new Circle(x, y, radius, Color.BLACK);
    circle.setStrokeType(StrokeType.OUTSIDE);
    circle.setStroke(Color.TRANSPARENT);
    circle.setStrokeWidth((hitRadius < radius) ? 0 : (hitRadius - radius));
    return circle;
}

@Override
public void start(Stage primaryStage) {
    Pane root = new Pane();
    Circle circle1 = createCircle(100, 100, 5, 20);
    Circle circle2 = createCircle(150, 150, 5, 20);

    circle1.setOnMouseClicked(evt -> System.out.println("clicked 1"));
    circle2.setOnMouseClicked(evt -> System.out.println("clicked 2"));

    root.getChildren().addAll(
            circle1,
            circle2
    );

    Scene scene = new Scene(root, 400, 400);

    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
}