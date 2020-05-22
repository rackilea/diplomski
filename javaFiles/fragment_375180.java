public class ClientGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ClientGUI.fxml"));
        scene = new Scene(root, 480, 360);
        stage.setTitle("MyMessenger");
        stage.setScene(scene);
        stage.setMinWidth(660);
        stage.setMinHeight(495);
        stage.setMaxWidth(990);
        stage.show();
    }
}