FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/SelectableList.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    fxmlLoader.setClassLoader(getClass().getClassLoader());
    try {
        fxmlLoader.load();
    } catch (IOException exception) {
        throw new RuntimeException(exception);
    }