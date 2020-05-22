public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
    loader.setControllerFactory(new HostServicesControllerFactory(getHostServices()));
    Parent root = loader.load();
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
}