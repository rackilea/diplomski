@FXML
private void joinAction() {
    Parent root;
    try {
        Stage stage = (Stage) joinButton.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader (getClass().getResource("main.fxml"));
        loader.setController(this);
        root = loader.load();
        stage = new Stage();
        stage.setTitle("TuneUs");
        stage.setScene(new Scene(root));
        stage.show();

    } catch (IOException e) {e.printStackTrace();}
}

@FXML
private void sendChat() {
    // ...
}