public Container() {
    // FXMLLOADER
    FXMLLoader loader = new FXMLLoader(getClass().getResource("SpeechWindow.fxml"));

    // set controller & root
    loader.setController(this);
    loader.setRoot(this);
    try {
        loader.load();
    } catch (IOException ex) {
        // throw as cause of RuntimeException
        throw new IllegalStateException(ex);
    }
}