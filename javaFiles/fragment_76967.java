@Override
public void start(Stage stage) {
    stage.setTitle("Placeholder Title");
    Canvas canvas = new Canvas(1280, 720);
    Group root = new Group(canvas);
    Scene scene = new Scene(root, 1280, 720);
    stage.setScene(scene);
    PixelWriter pw = canvas.getGraphicsContext2D().getPixelWriter();
    testRender(pw);
    stage.show();
}

private static void testRender(PixelWriter pw) {
    int c = -1;
    for (int x = 0; x < 1280; x++) {
        for (int y = 0; y < 720; y++, c--) {
            pw.setArgb(x, y, c);
        }
    }
}