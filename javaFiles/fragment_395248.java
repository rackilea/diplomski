FXMLLoader loader = new FXMLLoader();
loader.setResources(ResourceBundle.getBundle("propertyreader.application"));
Parent root = loader.load(
    getClass().getResourceAsStream(
            "about.fxml"
    )
);