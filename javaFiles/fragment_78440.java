public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(loader.load(), 800, 400));
    primaryStage.show();

    Controller controller = loader.getController();

    Machinery machinery = new Machinery(text ->
        Platform.runLater(() -> controller.setLabel(text)));

    Thread machineryThread = new Thread(machinery::doMachineryWork);
    machineryThread.start();
  }