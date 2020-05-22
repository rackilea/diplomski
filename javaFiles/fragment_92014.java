public void start(Stage primaryStage) throws Exception {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
    Parent root = loader.load();
    MainController controller = loader.getController();
    controller.setHostServices(getHostServices());
    primaryStage.setScene(new Scene(root));
    primaryStage.show();

}