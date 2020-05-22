@Override
public void start(Stage primaryStage) {
    Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Smiley.svg/240px-Smiley.svg.png");
    Canvas canvas = new Canvas(500, 500);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Slider slider = new Slider(0, 360, 0);
    Button btn = new Button("draw");
    VBox root = new VBox(canvas, slider, btn);


    btn.setOnAction(evt -> {
        context.setFill(Color.TRANSPARENT);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double posX = 200;
        double posY = 150;

        context.save();

        // apply transformation that puts makes (posX, posY) the point
        // where (0,0) is drawn and rotate
        context.translate(posX, posY);
        context.rotate(slider.getValue());

        // draw with center at (0, 0)
        context.drawImage(image, -image.getWidth()/2, -image.getHeight()/2);

        // undo transformations
        context.restore();
    });

    primaryStage.setScene(new Scene(root));
    primaryStage.show();
}