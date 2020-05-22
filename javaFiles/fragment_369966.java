@Override
public void start(Stage stage) {
    ImageView border = new ImageView("https://image.freepik.com/free-photo/wood-texture-plank-background_1372-642.jpg");
    ImageView screen = new ImageView("https://ak9.picdn.net/shutterstock/videos/1137709/thumb/9.jpg");
    border.setFitWidth(500);
    border.setFitHeight(500);
    screen.setFitWidth(400);
    screen.setFitHeight(400);

    Path clip = new Path(new MoveTo(50, 400), new ArcTo(50, 200, 0, 50, 0, false, true), new HLineTo(350), new ArcTo(50, 200, 0, 350, 400, false, true), new ClosePath());
    clip.setFill(Color.BLACK);
    clip.setStroke(null);
    screen.setClip(clip);

    StackPane root = new StackPane(border, screen);

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
}