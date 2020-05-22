public class Main extends Application {

    Image image = new Image("https://i.stack.imgur.com/UPmqE.png");

    @Override
    public void start(Stage primaryStage) {
        ImageView colorView = new ImageView(image);
        ImageView bhView = new ImageView(image);

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-1);
        bhView.setEffect(colorAdjust);

        primaryStage.setScene(new Scene(new VBox(colorView, bhView)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}