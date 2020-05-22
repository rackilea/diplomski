public static void drawStop(double x, double y, String text, GraphicsContext gc) {
    gc.save();

    gc.translate(x, y);
    gc.fillRect(-5, 0, 10, 10);
    gc.rotate(-40);
    gc.fillText(text, 5, 0);

    gc.restore();
}

@Override
public void start(Stage primaryStage) {
    Canvas canvas = new Canvas(900, 400);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    gc.setFont(Font.font ("Verdana", 20));

    drawStop(100, 380, "Stop 1", gc);
    drawStop(200, 380, "Stop 2", gc);
    drawStop(500, 380, "Stop 3 Stop 3 Stop 3 Stop 3 Stop 3 Stop 3", gc);

    Scene scene = new Scene(new Group(canvas));

    primaryStage.setScene(scene);
    primaryStage.show();
}