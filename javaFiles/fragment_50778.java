public void startNewScene() throws IOException{
    Stage stage = new Stage();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlfile.fxml"));
    Parent root = loader.load();
    MyController controller = loader.getController();
    Scene scene = new Scene(root);
    Stage.setScene(scene);
    stage.show();
}