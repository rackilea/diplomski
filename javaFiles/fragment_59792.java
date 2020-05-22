public class FXWidthBind extends Application {

    @Override
    public void start(Stage stage) {
        Media media = new Media("http://i.imgur.com/OJTwZuc.mp4");
        MediaPlayer player = new MediaPlayer(media);
        MediaView mediaView = new MediaView(player);

        Pane root = new Pane();
        Scene scene = new Scene(root);

        root.getChildren().add(mediaView);
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.setScene(scene);
        stage.show();

        mediaView.fitWidthProperty().bind(mediaView.getScene().widthProperty().subtract(64));
        mediaView.fitHeightProperty().bind(mediaView.getScene().heightProperty());
    }

    public static void main(String[] args) {
        launch(args);
    }
}