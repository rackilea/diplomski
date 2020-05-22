public static Point2D getDirection(Circle c1, Circle c2) {
    return new Point2D(c2.getCenterX() - c1.getCenterX(), c2.getCenterY() - c1.getCenterY()).normalize();
}

public static void connect(Circle c1, Circle c2, Line line) {
    InvalidationListener startInvalidated = observable -> {
        Point2D dir = getDirection(c1, c2);
        Point2D diff = dir.multiply(c1.getRadius());
        line.setStartX(c1.getCenterX() + diff.getX());
        line.setStartY(c1.getCenterY() + diff.getY());
    };
    InvalidationListener endInvalidated = observable -> {
        Point2D dir = getDirection(c2, c1);
        Point2D diff = dir.multiply(c2.getRadius());
        line.setEndX(c2.getCenterX() + diff.getX());
        line.setEndY(c2.getCenterY() + diff.getY());
    };
    c1.centerXProperty().addListener(startInvalidated);
    c1.centerYProperty().addListener(startInvalidated);
    c1.radiusProperty().addListener(startInvalidated);

    startInvalidated.invalidated(null);

    c2.centerXProperty().addListener(endInvalidated);
    c2.centerYProperty().addListener(endInvalidated);
    c2.radiusProperty().addListener(endInvalidated);

    endInvalidated.invalidated(null);
}

@Override
public void start(Stage primaryStage) {
    Circle c1 = new Circle(100, 100, 50, null);
    c1.setStroke(Color.BLUE);

    Circle c2 = new Circle(200, 200, 50, null);
    c2.setStroke(Color.RED);

    Line line = new Line();

    connect(c1, c2, line);

    Pane pane = new Pane(line, c1, c2);

    // demonstrate update during movement
    Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(c1.centerXProperty(), 100)),
            new KeyFrame(Duration.ZERO, new KeyValue(c1.centerYProperty(), 100)),
            new KeyFrame(Duration.seconds(1), new KeyValue(c1.centerXProperty(), 300)),
            new KeyFrame(Duration.seconds(1), new KeyValue(c1.centerYProperty(), 50)),
            new KeyFrame(Duration.ZERO, new KeyValue(c2.centerXProperty(), 200)),
            new KeyFrame(Duration.ZERO, new KeyValue(c2.centerYProperty(), 200)),
            new KeyFrame(Duration.seconds(1), new KeyValue(c2.centerXProperty(), 100)),
            new KeyFrame(Duration.seconds(1), new KeyValue(c2.centerYProperty(), 100))
    );

    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.setAutoReverse(true);

    timeline.play();

    Scene scene = new Scene(pane, 500, 500);

    primaryStage.setScene(scene);
    primaryStage.show();
}