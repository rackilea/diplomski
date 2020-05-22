public void showGameView() {
    try {
        System.out.println(game.getPlayer().getCurrentRoom());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/GameView.fxml"));
        loader.setController(new GameViewController(this));
        AnchorPane GameView = (AnchorPane) loader.load();
        rootLayout.setCenter(GameView);

    } catch (IOException e) {
        e.printStackTrace();
    }
}