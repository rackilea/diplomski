@Override
public void start(Stage primaryStage) throws IOException {
    FXMLLoader loader = new FXMLLoader(/*location*/);
    primaryStage.setScene(new Scene(loader.load()));
    primaryStage.show();
    loader.<Controller>getController().showMyAwesomeAlert();
}