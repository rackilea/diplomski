private static BorderPane loadMainPane() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setController(mainViewController);
        BorderPane mainPane = (BorderPane) loader.load(
                CsgoRr.class
                .getResourceAsStream(Info.Resource.FXML_FILE_MAIN));
        mainPane.getStylesheets().add(CsgoRr.class.getResource("path...style.css").toString());

        return mainPane;
    }