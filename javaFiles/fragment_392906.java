@Override
public void start(final Stage primaryStage) throws Exception{

    FXMLLoader loader = new FXMLLoader();
    Pane topPane  =  loader.load(getClass().getResource("xml/Main.fxml").openStream());
    Controller controllerOfTop = loader.getController();
    controllerOfTop.setText("Top");

    loader = new FXMLLoader();
    Pane bottomPane  =  loader.load(getClass().getResource("xml/Main.fxml").openStream());
    Controller controllerOfBottom = loader.getController();
    controllerOfBottom.setText("Bottom");

    Scene scene = new Scene(new VBox(topPane, bottomPane));
    primaryStage.setScene(scene);
    primaryStage.show();
}