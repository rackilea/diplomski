class Game {
    private final UI_Maker uiMaker;
    private final GameData gameData;
    private final GameStarter gameStarter;

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    private void start() {
        uiMaker.makeUI();
        gameData.loadData();
        gameStarter.start();
    }
}