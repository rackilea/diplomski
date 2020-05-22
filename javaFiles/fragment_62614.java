public class Main extends Application {

    private Stage stage;
    @Override
    public void start(Stage primaryStage){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainpane.fxml"));
        fxmlLoader.load();
        setStage(primaryStage);
        Parent root = fxmlLoader.getRoot(); 
        Scene scene = new Scene(root,800,800);
        primaryStage.setScene(scene);
        primaryStage.show();
        SampleController controller = loader.getController();
        new Thread(() -> new MyServer(controller).startDownload()).start();
    }
    public static void main(String[] args) {
        launch(args);
    }

}