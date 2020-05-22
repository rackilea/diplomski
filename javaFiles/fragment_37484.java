public void showResult(boolean win) throws IOException {
    if (win == true) {
        Parent menu_parent = FXMLLoader.load(getClass()
                               .getResource("/FXML/FXMLWinScreen.fxml"));
        Scene SceneMenu = new Scene(menu_parent);
        Stage stage = (Stage)show.getParent().getScene().getWindow();
        stage.setScene(SceneMenu);
        stage.show();
    }
}