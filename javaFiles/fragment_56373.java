@Override
public void start(Stage stage) throws IOException {
    Canvas canvas = new Canvas(512, 512);
    Scene scene = new Scene(new Pane(canvas));

    Random random = new Random();
    final int height = 16;
    final int width = 16;

    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(2d);

    for (int dy = 0; dy < height; dy++) {
        for (int dx = 0; dx < width; dx++) {
            gc.setFill(new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 1));
            gc.fillRect(dx * 32, dy * 32, 32, 32);
            gc.rect(dx * 32, dy * 32, 32, 32);
        }
    }

    // draw the path we've constructed during the loop
    gc.stroke();

    stage.setScene(scene);
    stage.show();
}