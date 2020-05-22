Parent root;
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(getClass().getClassLoader().getResource("path/to/yourFxml.fxml"));
            root = loader.load();
            Controllers.setMainControllerLoader(loader);
        } catch (IOException e) {
            // Failed to load fxml
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 600, 400));