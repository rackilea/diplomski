try {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatForm.fxml"));
    Pane p = loader.load();
    ChatForm chatForm = (ChatForm) loader.getController();
    chatForm.test();
} catch (IOException e) {
    e.printStackTrace();
}