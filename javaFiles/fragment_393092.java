private static ArcTo createArc(double radius, double dx, double dy) {
    ArcTo result = new ArcTo(radius, radius, 0, dx, dy, true, true);
    result.setAbsolute(false);
    return result;
}

private static HLineTo createHLine(double length) {
    HLineTo result = new HLineTo(length);
    result.setAbsolute(false);
    return result;
}

private static VLineTo createVLine(double length) {
    VLineTo result = new VLineTo(length);
    result.setAbsolute(false);
    return result;
}

private static Path createPath(double radius, double midSize, Color storke) {
    final double lineLength = 2 * radius + midSize;

    Path result = new Path(
            new MoveTo(radius, 2 * radius), // start at left end of top horizontal line
            createArc(radius, radius, -radius), // top left loop
            createVLine(lineLength), // down
            createArc(radius, -radius, -radius), // bottom left loop
            createHLine(lineLength), // right
            createArc(radius, -radius, radius), // bottom right loop
            createVLine(-lineLength), // up
            createArc(radius, radius, radius),
            new ClosePath() // left
    );
    result.setStroke(storke);
    result.setStrokeWidth(10);
    return result;
}

@Override
public void start(Stage primaryStage) throws Exception {
    Scene scene = new Scene(new StackPane(
            createPath(100, 50, Color.GREEN),
            createPath(50, 150, Color.AQUA)
    ));
    primaryStage.setScene(scene);
    primaryStage.show();
}