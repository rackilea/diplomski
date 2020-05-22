@Override
public void start(Stage stage) throws Exception{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));

    Scene scene = new Scene(loader.load());

    FXMLDocumentController controller = loader.getController();
    controller.initKeyActions(scene);

    stage.setScene(scene);
    stage.show();
}