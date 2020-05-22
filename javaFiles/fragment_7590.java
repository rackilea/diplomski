private static final double[] POLYGON_POINTS = {
    -5, -4,
    -5, 4,
    5, 0
};

private static void makeArrow(Pane parent, Circle start, Circle end, double t) {
    Polygon arrow = new Polygon(POLYGON_POINTS);
    arrow.setFill(null);
    arrow.setStroke(Color.BLACK);
    double dx = end.getCenterX() - start.getCenterX();
    double dy = end.getCenterY() - start.getCenterY();

    double d = Math.hypot(dx, dy);

    double sin = dy / d;
    double cos = dx / d;

    // matrix:
    //  [  cos     -sin     0    t * dx + start.getCenterX() ]        
    //  [  sin      cos     0    t * dy + start.getCenterY() ]        
    //  [   0        0      1                   0            ]        
    //  [   0        0      0                   1            ]
    Affine affine = new Affine(cos, -sin, t * dx + start.getCenterX(), sin, cos, t * dy + start.getCenterY());

    arrow.getTransforms().add(affine);
    parent.getChildren().add(arrow);
}

@Override
public void start(Stage primaryStage) {
    Circle end = new Circle(200, 20, 5);
    Circle start = new Circle(20, 200, 5);
    Line line = new Line(start.getCenterX(), start.getCenterY(), end.getCenterX(), end.getCenterY());

    Pane root = new Pane(line, start, end);

    makeArrow(root, start, end, 0.5);

    Scene scene = new Scene(root, 400, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}