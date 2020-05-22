private void insertPane(String fxmlFileName, AnchorPane parent, Initializable controller, String cssFileName) {
    try {
        URL fxmlUrl = getClass().getResource(fxmlFileName);
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        fxmlLoader.setController(controller);
        Parent pane = fxmlLoader.load();
        if (cssFileName != null) {
            pane.getStylesheets().add(getClass().getResource(cssFileName).toExternalForm());
        }
        parent.getChildren().add(pane);
        AnchorPane.setBottomAnchor(pane, 0d);
        AnchorPane.setTopAnchor(pane, 0d);
        AnchorPane.setLeftAnchor(pane, 0d);
        AnchorPane.setRightAnchor(pane, 0d);
    }
    catch (IOException ioe) {
        ioe.printStackTrace();
    }
}