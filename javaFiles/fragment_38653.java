class MainPane extends BorderPane {
    MainPane(final Stage stage) {
        stage.setTitle("Aplipikacka");

        // open the login dialog only when the stage is opened too.
        stage.setOnShown(event -> Platform.runLater(this::showLoginDialog));
    }

    private void showLoginDialog() {
        LoginDialog login = new LoginDialog();
        Optional<Pair<String, String>> result = login.getResult();
        // TODO finish here
    }
}