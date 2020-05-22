private Pane loadMainPane() throws IOException {

    FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(Navigator.PANE));

    Pane mainPane = loader.load();

    MainController mainController = loader.getController();

    Navigator.setMainController(mainController);

    Navigator.loadVista("login.fxml");

    return mainPane ;
}