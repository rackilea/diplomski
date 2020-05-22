public static void drawStop(double x, double y, String text, GraphicsContext gc, Pane pane) {
    gc.fillRect(x-5, y, 10, 10);
    Text textNode = new Text(text);
    textNode.setFont(Font.font ("Verdana", 20));
    textNode.setBoundsType(TextBoundsType.VISUAL);
    textNode.relocate(x, y-15);
    textNode.getTransforms().add(new Rotate(-40));
    pane.getChildren().add(textNode);
}

@Override
public void start(Stage primaryStage) {
    Pane pane = new Pane();
    Canvas canvas = new Canvas(900, 400);
    pane.getChildren().add(canvas);

    GraphicsContext gc = canvas.getGraphicsContext2D();

    drawStop(100, 380, "Stop 1", gc, pane);
    drawStop(200, 380, "Stop 2", gc, pane);
    drawStop(500, 380, "Stop 3 Stop 3 Stop 3 Stop 3 Stop 3 Stop 3", gc, pane);

    Scene scene = new Scene(pane);

    primaryStage.setScene(scene);
    primaryStage.show();
}