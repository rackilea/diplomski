public class GUIApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/sample.fxml"));

        Parent root = (Parent) loader.load();
        primaryStage.setTitle("Allowed Site Configurator");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }

}