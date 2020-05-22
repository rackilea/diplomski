public class Main extends Application {


    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/entry.fxml"));
        Parent root = loader.load();
        SystemMessage mainController = loader.getController();
        primaryStage.setTitle("Car");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Task<String> carTask = new Task<String>() {
            @Override
            protected String call() throws Exception {
                Car myCar = new Car();
                myCar.startEngine();
                return myCar.engineIdle();
            }
        };
        carTask.setOnSucceeded(e -> mainController.postMessage(carTask.getValue()));
        new Thread(carTask).start();

    }

}