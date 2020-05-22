public class DrawImage extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root =  FXMLLoader.load(getClass().getResource("DrawImage.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
        scene.getRoot().requestFocus();//key event needs focus
    }

    public static void main(String[] args) {
        launch(args);
    }
}