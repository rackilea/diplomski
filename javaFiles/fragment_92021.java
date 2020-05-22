public class MainApp extends Application {

    private static HostServices hostServices ;

    public static HostServices getHostServices() {
        return hostServices ;
    }

    public void start(Stage primaryStage) throws Exception {

        hostServices = getHostServices();

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}